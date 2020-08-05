package top.jloeve.aigou.tests;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import top.jloeve.aigou.domains.impl.Product;
import top.jloeve.aigou.domains.impl.ProductType;
import top.jloeve.aigou.mappers.ProductTypeMapper;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestProductTypeMapper extends TestCase {

  @Autowired private ProductTypeMapper productTypeMapper;

  public void assertProductType(ProductType productType) {
    assertNotNull(productType.getUuid());
    assertNotNull(productType.getDesc());
    assertNotNull(productType.getIconClassName());
    assertNotNull(productType.getName());
  }

  @Test
  public void testQueryAll() {
    List<ProductType> productTypes;

    productTypes = productTypeMapper.queryAll();
    assertTrue(productTypes.size() > 0);

    ProductType productType = productTypes.get(0);
    assertProductType(productType);
  }

  @Test
  public void testQueryByParams() {
    String[] brandUUIDs = {
      "b8eaceed-7b72-44e8-bfab-cb46601399a8", "00760bcd-da11-4596-9338-d6fe39181e9c"
    };
    ProductType productType =
        productTypeMapper.queryByParams("0eba44a1-41d5-4156-b0f0-c16475c084ac", brandUUIDs, "子");
    assertProductType(productType);
  }
}
