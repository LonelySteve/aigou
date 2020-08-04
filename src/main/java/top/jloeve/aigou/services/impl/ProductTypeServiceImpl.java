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
  public ProductType getById(String uuid) {
    return productTypeMapper.queryById(uuid);
  }

  @Override
  public List<ProductType> getAll() {
    return productTypeMapper.query();
  }
}
