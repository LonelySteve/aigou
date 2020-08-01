package top.jloeve.aigou.mappers;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.jloeve.aigou.domains.impl.OrderProduct;

import java.util.List;

@Repository
public interface OrderProductMapper {
  List<OrderProduct> queryBySales(@Param("limit") Integer limit);
}
