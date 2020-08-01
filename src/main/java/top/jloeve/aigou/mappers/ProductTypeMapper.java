package top.jloeve.aigou.mappers;

import org.springframework.stereotype.Repository;
import top.jloeve.aigou.domains.impl.ProductType;

import java.util.List;

@Repository
public interface ProductTypeMapper {
  List<ProductType> query();
}
