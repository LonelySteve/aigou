package top.jloeve.aigou.tests;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import top.jloeve.aigou.domains.impl.Brand;
import top.jloeve.aigou.mappers.BrandMapper;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestBrandMapper extends TestCase {
  @Autowired private BrandMapper brandMapper;

  public void assertBrand(Brand brand) {
    assertNotNull(brand.getUuid());
    assertNotNull(brand.getImageFileName());
    assertNotNull(brand.getName());
    assertNotNull(brand.getType());
    assertNotNull(brand.getType().getUuid());
  }

  @Test
  public void testQueryByTypeId() {
    List<Brand> brands = brandMapper.queryByTypeId("0eba44a1-41d5-4156-b0f0-c16475c084ac");
    assertTrue(brands.size() > 0);

    Brand brand = brands.get(0);
    assertBrand(brand);
  }
}
