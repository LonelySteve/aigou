package top.jloeve.aigou.controllers;

import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/captcha")
public class CaptchaController extends BaseController {
  @RequestMapping("")
  public void index(HttpServletRequest request, HttpServletResponse response) throws IOException {
    CaptchaUtil.out(request, response);
  }
}
