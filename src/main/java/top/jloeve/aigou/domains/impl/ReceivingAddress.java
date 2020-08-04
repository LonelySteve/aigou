package top.jloeve.aigou.domains.impl;

import lombok.Data;
import top.jloeve.aigou.domains.IDomain;

@Data
public class ReceivingAddress implements IDomain {
  private String uuid;
  private String address;
  private String receivingPersonName;
  private String mobilePhone;
  private User user;
  private boolean isDefault;
}
