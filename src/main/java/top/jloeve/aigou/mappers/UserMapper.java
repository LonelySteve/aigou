package top.jloeve.aigou.mappers;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.jloeve.aigou.domains.impl.User;

@Repository
public interface UserMapper {
  boolean signUp(
      @Param("username") String username,
      @Param("password") String password,
      @Param("typeId") int typeId);

  boolean exist(@Param("username") String username);

  User login(@Param("username") String username, @Param("password") String password);
}
