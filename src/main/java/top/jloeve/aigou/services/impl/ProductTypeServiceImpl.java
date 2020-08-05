package top.jloeve.aigou.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jloeve.aigou.domains.impl.ProductType;
import top.jloeve.aigou.mappers.ProductTypeMapper;
import top.jloeve.aigou.services.IProductTypeService;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements IProductTypeService {
  private final ProductTypeMapper productTypeMapper;

  @Autowired
  public ProductTypeServiceImpl(ProductTypeMapper productTypeMapper) {
    this.productTypeMapper = productTypeMapper;
  }

  @Override
  public ProductType getByParams(String productTypeUUID, String[] brands, String keyword) {
    return productTypeMapper.queryByParams(productTypeUUID, brands, keyword);
  }

  @Override
  public String getSearchAttributeName() {
    return "targetProductType";
  }
}
