package top.jloeve.aigou.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import top.jloeve.aigou.services.IUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Component
public class LoginInterceptor implements HandlerInterceptor {
  private final IUserService userService;

  public LoginInterceptor(IUserService userService) {
    this.userService = userService;
  }

  @Override
  public boolean preHandle(
      HttpServletRequest request, HttpServletResponse response, Object handler) {
    if (userService == null) return true;
    try {
      userService.login(request, response);
      // 登录无异常证明登录成功，检查当前请求页是否为登录页，如果是则重定向到首页
      if (request.getServletPath().equals("/user/login")) {
        response.sendRedirect("/");
        return false;
      }
    } catch (Exception ignored) {
    }

    return true;
  }
}
