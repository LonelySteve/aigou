package top.jloeve.aigou.tests;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import top.jloeve.aigou.domains.impl.Product;
import top.jloeve.aigou.mappers.ProductMapper;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestProductMapper extends TestCase {
  @Autowired private ProductMapper productMapper;

  @Test
  public void testQueryNewProducts() {
    List<Product> products;

    products = productMapper.queryNewProducts(null);
    assertTrue(products.size() > 0);

    products = productMapper.queryNewProducts(0);
    assertEquals(0, products.size());

    products = productMapper.queryNewProducts(1);
    assertEquals(1, products.size());

    Product product = products.get(0);

    assertNotNull(product.getId());
    assertNotNull(product.getCreateTime());
    assertNotNull(product.getPrice());
    assertNotNull(product.getProductImage());
    assertNotNull(product.getProductName());
  }

  @Test
  public void testQueryByProductTypeName() {
    List<Product> products;

    products = productMapper.queryByProductTypeName(null, null);
    assertTrue(products.size() > 0);

    products = productMapper.queryByProductTypeName(null, 1);
    assertEquals(1, products.size());

    products = productMapper.queryByProductTypeName("国产食品", 1);
    assertEquals(1, products.size());

    Product product = products.get(0);
    assertNotNull(product.getId());
    assertNotNull(product.getProductName());
    assertNotNull(product.getProductDesc());
    assertNotNull(product.getPrice());
    assertNotNull(product.getProductImage());
    assertNotNull(product.getCreateTime());
    assertNotNull(product.getType());
    assertNotNull(product.getBrand());
  }
}
