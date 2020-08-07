package top.jloeve.aigou.services.impl;

import lombok.extern.java.Log;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.DateUtils;
import top.jloeve.aigou.domains.impl.User;
import top.jloeve.aigou.mappers.UserMapper;
import top.jloeve.aigou.services.IUserService;
import top.jloeve.aigou.utils.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.stream.Stream;

@Service
@Log
public class UserServiceImpl implements IUserService {
  private final UserMapper userMapper;
  private final String hash = "3053150cd7cd11ea9a2058fb845fce30";

  @Autowired
  public UserServiceImpl(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  @Override
  public void login(
      HttpServletRequest request,
      HttpServletResponse response,
      String username,
      String password,
      boolean keepOneWeekExpires)
      throws Exception {
    HttpSession session = request.getSession();
    String passwordDigest = null;
    // 如果传参进来的 username 为 null，则尝试从 Session 中恢复登录凭证
    if (username == null && password == null) {
      List<Cookie> cookies = Arrays.asList(request.getCookies());
      if (cookies.stream().noneMatch(cookie -> cookie.getName().equals("username"))) {
        throw new Exception("登录状态已失效，请重新登录");
      }
      Optional<Cookie> usernameCookie =
          cookies.stream().filter(c -> c.getName().equals("username")).findFirst();
      Optional<Cookie> passwordCookie =
          cookies.stream().filter(c -> c.getName().equals("password")).findFirst();

      if (usernameCookie.isPresent()) {
        username = usernameCookie.get().getValue();
      }
      if (passwordCookie.isPresent()) {
        password = passwordCookie.get().getValue();
      }
      // 从 Cookie 中恢复登录信息，无法刷新有效期，强制使 keepOneWeekExpires 参数为 False
      keepOneWeekExpires = false;
    }
    if (StringUtils.isEmptyOrNull(username)) {
      throw new Exception("用户名为空");
    }
    if (StringUtils.isEmptyOrNull(password)) {
      throw new Exception("密码为空");
    }
    if (passwordDigest == null) {
      // 取密码 MD5 加盐哈希值
      passwordDigest = encryptPassword(password);
    }
    // 查询是否存在指定用户名和指定密码的用户注册信息
    User user = userMapper.login(username, passwordDigest);
    if (user == null) {
      throw new Exception("用户不存在或密码错误");
    }
    if (keepOneWeekExpires) {
      Cookie[] cookies =
          new Cookie[] {new Cookie("username", username), new Cookie("password", password)};

      Arrays.stream(cookies)
          .forEach(
              c -> {
                // 保持一周的有效期
                c.setMaxAge(7 * 24 * 60 * 60);
                c.setPath("/");
                response.addCookie(c);
              });
    }
    session.setAttribute("loginUser", user);
  }

  private String encryptPassword(String password) throws NoSuchAlgorithmException {
    MessageDigest md5 = null;
    try {
      md5 = MessageDigest.getInstance("MD5");
      byte[] digest = md5.digest((password + hash).getBytes());
      return DatatypeConverter.printHexBinary(digest).toLowerCase();
    } catch (NoSuchAlgorithmException e) {
      log.log(Level.FINE, "未找到 MD5 密码摘要算法", e.getCause());
      throw e;
    }
  }

  @Override
  public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
    login(request, response, null, null, false);
  }

  @Override
  public void logout(HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession();

    Cookie[] cookies = new Cookie[] {new Cookie("username", null), new Cookie("password", null)};

    Arrays.stream(cookies)
        .forEach(
            c -> {
              c.setMaxAge(0);
              c.setPath("/");
              response.addCookie(c);
            });

    session.removeAttribute("loginUser");
  }

  @Override
  public void signUp(String username, String password) throws Exception {
    String passwordDigest = encryptPassword(password);
    if (!userMapper.signUp(username, passwordDigest, 0)) { // 无后台实现计划，默认注册用户为普通用户 0
      throw new Exception("注册失败");
    }
  }
}
