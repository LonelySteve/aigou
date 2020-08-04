package top.jloeve.aigou.domains.impl;


import lombok.Data;
import top.jloeve.aigou.domains.IDomain;

import java.util.Date;

@Data
public class Order implements IDomain {
  private String uuid;
  private Date createTime;
  private ReceivingAddress receivingAddress;
  private User user;
}
