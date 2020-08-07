package top.jloeve.aigou;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.jloeve.aigou.interceptors.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
  private final LoginInterceptor loginInterceptor;

  @Autowired
  public WebConfig(LoginInterceptor loginInterceptor) {
    this.loginInterceptor = loginInterceptor;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(loginInterceptor);
  }
}
