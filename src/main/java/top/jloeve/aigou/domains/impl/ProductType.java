package top.jloeve.aigou.domains.impl;

import lombok.Data;
import top.jloeve.aigou.domains.IDomain;

@Data
public class ProductType implements IDomain {
  private String uuid;
  private String name;
  private String desc;
  private String iconClassName;
}
