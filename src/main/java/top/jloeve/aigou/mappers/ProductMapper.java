package top.jloeve.aigou.mappers;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.jloeve.aigou.domains.impl.Product;

import java.util.List;

@Repository
public interface ProductMapper {
  List<Product> queryNewProducts(@Param("limit") Integer limit);

  List<Product> queryByProductTypeName(
      @Param("productTypeName") String productTypeName, @Param("limit") Integer limit);
}
