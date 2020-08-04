package top.jloeve.aigou.tests;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
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
  public void testQuery() {
    List<ProductType> productTypes;

    productTypes = productTypeMapper.query();
    assertTrue(productTypes.size() > 0);

    ProductType productType = productTypes.get(0);
    assertProductType(productType);
  }

  @Test
  public void testQueryById() {
    ProductType productType = productTypeMapper.queryById("09c6fb44-4219-4760-89a9-d179682e423e");
    assertProductType(productType);
  }
}
