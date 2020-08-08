package top.jloeve.aigou.controllers;

import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.jloeve.aigou.services.IUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
  private final IUserService userService;

  @Autowired
  public UserController(IUserService userService) {
    this.userService = userService;
  }

  @GetMapping("/login")
  public String login() {
    return "user/login";
  }

  @PostMapping("/login")
  @ResponseBody
  public String login(
      HttpServletRequest request,
      HttpServletResponse response,
      @RequestParam("username") String username,
      @RequestParam("password") String password,
      @RequestParam("code") String code,
      @RequestParam(value = "keep", required = false) boolean keep) {
    if (verifyCaptchaFail(request, code)) return "验证码错误";
    try {
      userService.login(request, response, username, password, keep);
    } catch (Exception e) {
      return e.getMessage();
    }
    return "登录成功";
  }

  @PostMapping("/logout")
  @ResponseBody
  public String logout(HttpServletRequest request, HttpServletResponse response) {
    userService.logout(request, response);
    return "登出成功";
  }

  @GetMapping("/signup")
  public String signUp() {
    return "user/signup";
  }

  @PostMapping("/signup")
  @ResponseBody
  public String signUp(
      HttpServletRequest request,
      @RequestParam("username") String username,
      @RequestParam("password") String password,
      @RequestParam("code") String code) {
    if (verifyCaptchaFail(request, code)) return "验证码错误";
    try {
      userService.signUp(username, password);
    } catch (Exception e) {
      return e.getMessage();
    }
    return "注册成功";
  }

  private boolean verifyCaptchaFail(HttpServletRequest request, @RequestParam("code") String code) {
    boolean success = CaptchaUtil.ver(code, request);
    // 清除存储在 Session 中的验证码核实信息
    // 一旦进行验证码验证，无论是否成功都需要清除此信息，否则验证码会形同虚设！
    CaptchaUtil.clear(request);

    return !success;
  }
}
