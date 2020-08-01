package top.jloeve.aigou.domains.impl;

import lombok.Data;
import top.jloeve.aigou.domains.IDomain;

@Data
public class Carousel implements IDomain {
  public String id;
  public String url;
  public Integer sequenceNum;
}
