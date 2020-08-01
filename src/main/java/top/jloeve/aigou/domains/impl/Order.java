package top.jloeve.aigou.domains.impl;


import lombok.Data;
import top.jloeve.aigou.domains.IDomain;

import java.util.Date;

@Data
public class Order implements IDomain {
  private String id;
  private Date createTime;
  private String receivingAddress;
  private User user;
}
