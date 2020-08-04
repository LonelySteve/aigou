package top.jloeve.aigou.services;

import top.jloeve.aigou.domains.impl.ProductType;

import java.util.List;

public interface IProductTypeService extends IService {
  ProductType getById(String uuid);

  List<ProductType> getAll();
}
