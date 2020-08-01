package top.jloeve.aigou.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jloeve.aigou.domains.impl.OrderProduct;
import top.jloeve.aigou.domains.impl.Product;
import top.jloeve.aigou.domains.impl.ProductType;
import top.jloeve.aigou.mappers.OrderProductMapper;
import top.jloeve.aigou.mappers.ProductMapper;
import top.jloeve.aigou.mappers.ProductTypeMapper;
import top.jloeve.aigou.services.IProductService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {

  private final ProductTypeMapper productTypeMapper;
  private final ProductMapper productMapper;
  private final OrderProductMapper orderProductMapper;

  @Autowired
  public ProductServiceImpl(
      ProductMapper productMapper,
      ProductTypeMapper productTypeMapper,
      OrderProductMapper orderProductMapper) {
    this.productTypeMapper = productTypeMapper;
    this.productMapper = productMapper;
    this.orderProductMapper = orderProductMapper;
  }

  @Override
  public List<ProductType> getAllProductTypes() {
    return productTypeMapper.query();
  }

  @Override
  public List<Product> getNewProducts(Integer limit) {
    return productMapper.queryNewProducts(limit);
  }

  @Override
  public List<Product> getRankingProducts(Integer limit) {
    return orderProductMapper.queryBySales(limit).stream()
        .map(OrderProduct::getProduct)
        .collect(Collectors.toList());
  }

  @Override
  public List<Product> getByProductTypeName(String name, Integer limit) {
    return productMapper.queryByProductTypeName(name, limit);
  }
}
