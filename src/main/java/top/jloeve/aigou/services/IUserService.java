package top.jloeve.aigou.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IUserService extends IService {
  void login(
      HttpServletRequest request,
      HttpServletResponse response,
      String username,
      String password,
      boolean keepOneWeekExpires)
      throws Exception;

  void login(HttpServletRequest request, HttpServletResponse response) throws Exception;

  void logout(HttpServletRequest request, HttpServletResponse response);

  void signUp(String username, String password) throws Exception;
}
