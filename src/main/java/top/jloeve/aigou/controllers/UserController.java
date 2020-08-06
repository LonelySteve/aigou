package top.jloeve.aigou.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
  @RequestMapping("/login")
  public String login() {
    return "user/login";
  }

  @RequestMapping("/signup")
  public String signUp() {
    return "user/signup";
  }
}
