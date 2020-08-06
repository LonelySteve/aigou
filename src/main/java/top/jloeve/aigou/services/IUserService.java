package top.jloeve.aigou.services;

import javax.servlet.http.HttpSession;

public interface IUserService extends IService {
  void login(HttpSession session, String username, String password, boolean keepOneWeekExpires)
      throws Exception;

  void login(HttpSession session) throws Exception;

  void logout(HttpSession session);

  void signUp(String username, String password) throws Exception;
}
