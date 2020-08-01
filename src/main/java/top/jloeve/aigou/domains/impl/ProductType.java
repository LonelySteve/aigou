package top.jloeve.aigou.domains.impl;

import lombok.Data;
import top.jloeve.aigou.domains.IDomain;

@Data
public class ProductType implements IDomain {
  private String id;
  private String productTypeName;
  private String productTypeDesc;
  private String productTypeIcon;
}
