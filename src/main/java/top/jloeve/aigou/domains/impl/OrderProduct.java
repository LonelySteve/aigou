package top.jloeve.aigou.domains.impl;

import lombok.Data;
import top.jloeve.aigou.domains.IDomain;

@Data
public class OrderProduct implements IDomain {
  private String id;
  private Integer productNum;
  private Product product;
  private Order order;
}
