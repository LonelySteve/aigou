package top.jloeve.aigou.tests;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import top.jloeve.aigou.domains.impl.OrderProduct;
import top.jloeve.aigou.mappers.OrderProductMapper;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestOrderProductMapper extends TestCase {
  @Autowired private OrderProductMapper productMapper;

  @Test
  public void testQueryBySales() {
    List<OrderProduct> orderProducts;

    orderProducts = productMapper.queryBySales(null);
    assertTrue(orderProducts.size() > 0);

    orderProducts = productMapper.queryBySales(0);
    assertEquals(0, orderProducts.size());

    orderProducts = productMapper.queryBySales(1);
    assertEquals(1, orderProducts.size());

    OrderProduct orderProduct = orderProducts.get(0);

    assertNotNull(orderProduct.getId());
    assertNotNull(orderProduct.getProductNum());
    assertNotNull(orderProduct.getOrder());
    assertNotNull(orderProduct.getOrder().getId());
    assertNotNull(orderProduct.getProduct());
    assertNotNull(orderProduct.getProduct().getId());
    assertNotNull(orderProduct.getProduct().getType());
    assertNotNull(orderProduct.getProduct().getType().getId());
    assertNotNull(orderProduct.getProduct().getProductDesc());
    assertNotNull(orderProduct.getProduct().getProductName());
    assertNotNull(orderProduct.getProduct().getProductImage());
    assertNotNull(orderProduct.getProduct().getCreateTime());
    assertNotNull(orderProduct.getProduct().getBrand());
    assertNotNull(orderProduct.getProduct().getPrice());
  }
}
