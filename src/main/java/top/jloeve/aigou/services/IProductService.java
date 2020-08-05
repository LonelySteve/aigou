package top.jloeve.aigou.services;

import top.jloeve.aigou.domains.impl.Product;
import top.jloeve.aigou.domains.impl.ProductType;

import java.util.List;

public interface IProductService extends ISearchService<List<Product>> {

  List<ProductType> getAllProductTypes();

  default List<Product> getNewProducts() {
    return getNewProducts(null);
  }

  default List<Product> getRankingProducts() {
    return getRankingProducts(null);
  }

  List<Product> getNewProducts(Integer limit);

  List<Product> getRankingProducts(Integer limit);

  default List<Product> getByProductTypeName(String name) {
    return getByProductTypeName(name, null);
  }

  List<Product> getByProductTypeName(String name, Integer limit);

  Product getByUUID(String uuid);
}
