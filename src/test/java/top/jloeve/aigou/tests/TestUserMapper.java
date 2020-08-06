package top.jloeve.aigou.tests;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import top.jloeve.aigou.domains.impl.User;
import top.jloeve.aigou.mappers.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestUserMapper extends TestCase {

  @Autowired private UserMapper userMapper;

  private void assertUser(User user) {
    assertNotNull(user);
    assertNotNull(user.getUuid());
    assertNotNull(user.getUsername());
    assertNull(user.getPassword());
    assertNotNull(user.getTypeId());
  }

  @Test
  public void testExist() {
    assertTrue(userMapper.exist("大王"));
  }

  @Test
  public void testLogin() {
    User user = userMapper.login("大王", "eccbc87e4b5ce2fe28308fd9f2a7baf3");
    assertUser(user);
  }

  @Test
  public void testSignUp() {
    userMapper.signUp("测试一下", "eccbc87e4b5ce2fe28308fd9f2a7baf3", 0);
    User user = userMapper.login("测试一下", "eccbc87e4b5ce2fe28308fd9f2a7baf3");
    assertUser(user);
  }
}
