package top.jloeve.aigou.services;

import top.jloeve.aigou.domains.impl.Brand;

import java.util.List;

public interface IBrandService extends IService {
  List<Brand> getByTypeId(String productTypeUuid);
}
