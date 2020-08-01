package top.jloeve.aigou.domains.impl;

import lombok.Data;
import top.jloeve.aigou.domains.IDomain;

@Data
public class Brand implements IDomain {
  private String id;
  private String brandName;
  private String brandType;
  private String brandImg;
}
