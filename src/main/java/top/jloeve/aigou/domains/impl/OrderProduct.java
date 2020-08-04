package top.jloeve.aigou.domains.impl;

import lombok.Data;
import top.jloeve.aigou.domains.IDomain;

@Data
public class OrderProduct implements IDomain {
  private String uuid;
  private Integer productCount;
  private Product product;
  private Order order;
}
