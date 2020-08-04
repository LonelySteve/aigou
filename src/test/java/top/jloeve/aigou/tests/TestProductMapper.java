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

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestProductMapper extends TestCase {
  @Autowired private ProductMapper productMapper;

  public void assertProduct(Product product) {
    assertNotNull(product.getUuid());
    assertNotNull(product.getDesc());
    assertNotNull(product.getImageFileName());
    assertNotNull(product.getName());
    assertNotNull(product.getType());
    assertNotNull(product.getType().getUuid());
    assertNotNull(product.getBrand());
    assertNotNull(product.getBrand().getUuid());
    assertNotNull(product.getCreateTime());
  }

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
    assertProduct(product);
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
    assertProduct(product);
  }

  @Test
  public void testQueryBySales() {
    List<Product> products;

    products = productMapper.queryBySales(null);
    assertTrue(products.size() > 0);

    products = productMapper.queryBySales(1);
    assertEquals(1, products.size());

    Product product = products.get(0);
    assertProduct(product);
  }

  @Test
  public void testQueryByParams() {
    String[] brandUUIDs = {
      "b8eaceed-7b72-44e8-bfab-cb46601399a8", "00760bcd-da11-4596-9338-d6fe39181e9c"
    };
    List<Product> products =
        productMapper.queryByParams(
            "0eba44a1-41d5-4156-b0f0-c16475c084ac", Arrays.asList(brandUUIDs), "子");
    assertEquals(1, products.size());
    assertProduct(products.get(0));
  }
}
