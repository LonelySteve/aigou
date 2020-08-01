package top.jloeve.aigou.domains.impl;

import java.util.Date;
import lombok.Data;
import top.jloeve.aigou.domains.IDomain;

@Data
public class Product implements IDomain {
  public String id;
  public String productName;
  public String productImage;
  public Double price;
  public String productDesc;
  public Date createTime;
  public Brand brand;
  public ProductType type;
}
