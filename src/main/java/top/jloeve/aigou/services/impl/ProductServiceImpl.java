package top.jloeve.aigou.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jloeve.aigou.domains.impl.Product;
import top.jloeve.aigou.domains.impl.ProductType;
import top.jloeve.aigou.mappers.ProductMapper;
import top.jloeve.aigou.mappers.ProductTypeMapper;
import top.jloeve.aigou.services.IProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

  private final ProductTypeMapper productTypeMapper;
  private final ProductMapper productMapper;

  @Autowired
  public ProductServiceImpl(ProductMapper productMapper, ProductTypeMapper productTypeMapper) {
    this.productTypeMapper = productTypeMapper;
    this.productMapper = productMapper;
  }

  @Override
  public List<ProductType> getAllProductTypes() {
    return productTypeMapper.queryAll();
  }

  @Override
  public List<Product> getNewProducts(Integer limit) {
    return productMapper.queryNewProducts(limit);
  }

  @Override
  public List<Product> getRankingProducts(Integer limit) {
    return productMapper.queryBySales(limit);
  }

  @Override
  public List<Product> getByProductTypeName(String name, Integer limit) {
    return productMapper.queryByProductTypeName(name, limit);
  }

  @Override
  public Product getByUUID(String uuid) {
    return productMapper.queryByUUID(uuid);
  }

  @Override
  public List<Product> getByParams(String productTypeUUID, String[] brands, String keyword) {
    return productMapper.queryByParams(productTypeUUID, brands, keyword);
  }

  @Override
  public String getSearchAttributeName() {
    return "products";
  }
}
