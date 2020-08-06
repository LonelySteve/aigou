package top.jloeve.aigou.services.impl;

import lombok.extern.java.Log;
import java.util.logging.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jloeve.aigou.domains.impl.User;
import top.jloeve.aigou.mappers.UserMapper;
import top.jloeve.aigou.services.IUserService;
import top.jloeve.aigou.utils.StringUtils;

import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Date;

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
      HttpSession session, String username, String password, boolean keepOneWeekExpires)
      throws Exception {
    String passwordDigest = null;
    // 如果传参进来的 username 为 null，则尝试从 Session 中恢复登录凭证
    if (username == null && password == null) {
      Date expires = (Date) session.getAttribute("expires");
      // 判断当前日期时间是否已经超过有效截止日期，如果已经超过则需要用户重新登录
      if (expires == null || !(new Date()).before(expires)) {
        throw new Exception("登录状态已失效，请重新登录");
      }
      username = (String) session.getAttribute("username");
      passwordDigest = (String) session.getAttribute("password");
      // 从会话中恢复登录信息，无法刷新有效期，强制使 keepOneWeekExpires 参数为 False
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
      session.setAttribute("username", username);
      session.setAttribute("password", passwordDigest);
      // 保持一周的有效期
      session.setAttribute("expires", LocalDateTime.from((new Date()).toInstant()).plusWeeks(1));
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
  public void login(HttpSession session) throws Exception {
    login(session, null, null, false);
  }

  @Override
  public void logout(HttpSession session) {
    session.removeAttribute("expires");
    session.removeAttribute("username");
    session.removeAttribute("password");
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
