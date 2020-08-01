package top.jloeve.aigou.domains.impl;

import lombok.Data;
import top.jloeve.aigou.domains.IDomain;

@Data
public class User implements IDomain {
  private String id;
  private String username;
  private String password;
  private Integer type;
}
