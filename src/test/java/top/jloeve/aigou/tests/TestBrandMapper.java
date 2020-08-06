package top.jloeve.aigou.tests;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import top.jloeve.aigou.domains.impl.Brand;
import top.jloeve.aigou.domains.impl.Product;
import top.jloeve.aigou.mappers.BrandMapper;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestBrandMapper extends TestCase {
  @Autowired private BrandMapper brandMapper;

  public void assertBrand(Brand brand) {
    assertNotNull(brand);
    assertNotNull(brand.getUuid());
    assertNotNull(brand.getImageFileName());
    assertNotNull(brand.getName());
    assertNotNull(brand.getType());
    assertNotNull(brand.getType().getUuid());
  }

  @Test
  public void testQueryByParams() {
    List<Brand> brands =
        brandMapper.queryByParams("29feb3d0-ad4d-4b86-aabc-aa80e435e29b", null, null);
    assertEquals(1, brands.size());
    Brand brand = brands.get(0);
    assertBrand(brand);
  }
}
