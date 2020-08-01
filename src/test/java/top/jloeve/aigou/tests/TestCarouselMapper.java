package top.jloeve.aigou.tests;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import top.jloeve.aigou.mappers.CarouselMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestCarouselMapper extends TestCase {

  @Autowired private CarouselMapper carouselMapper;

  @Test
  @Rollback
  public void testDao() {
    assertTrue(carouselMapper.query(null).size() != 0);
    for (int i = 0; i <= 3; i++) {
      assertEquals(i, carouselMapper.query(i).size());
    }
  }
}
