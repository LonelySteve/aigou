package top.jloeve.aigou.domains.impl;

import java.util.Date;
import lombok.Data;
import top.jloeve.aigou.domains.IDomain;

@Data
public class Product implements IDomain {
  public String uuid;
  public String name;
  public String imageFileName;
  public Double price;
  public String desc;
  public Integer saleCount;
  public Date createTime;
  public Brand brand;
  public ProductType type;
}
