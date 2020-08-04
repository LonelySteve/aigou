package top.jloeve.aigou.domains.impl;

import lombok.Data;
import top.jloeve.aigou.domains.IDomain;

@Data
public class Brand implements IDomain {
  private String uuid;
  private String name;
  private ProductType type;
  private String imageFileName;
}
