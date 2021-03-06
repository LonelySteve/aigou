package top.jloeve.aigou.mappers;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.jloeve.aigou.domains.impl.OrderProduct;
import top.jloeve.aigou.domains.impl.Product;

import java.util.List;

@Repository
public interface ProductMapper extends ISearchMapper<List<Product>> {
  List<Product> queryNewProducts(@Param("limit") Integer limit);

  List<Product> queryByProductTypeName(
      @Param("productTypeName") String productTypeName, @Param("limit") Integer limit);

  List<Product> queryBySales(@Param("limit") Integer limit);

  Product queryByUUID(@Param("uuid") String uuid);
}
