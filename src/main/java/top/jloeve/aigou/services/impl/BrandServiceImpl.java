package top.jloeve.aigou.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jloeve.aigou.domains.impl.Brand;
import top.jloeve.aigou.mappers.BrandMapper;
import top.jloeve.aigou.services.IBrandService;

import java.util.List;

@Service
public class BrandServiceImpl implements IBrandService {
  private final BrandMapper brandMapper;

  @Autowired
  public BrandServiceImpl(BrandMapper brandMapper) {
    this.brandMapper = brandMapper;
  }

  @Override
  public List<Brand> getByTypeId(String productTypeUuid) {
    return brandMapper.queryByTypeId(productTypeUuid);
  }
}
