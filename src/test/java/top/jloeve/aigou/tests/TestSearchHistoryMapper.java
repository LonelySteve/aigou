package top.jloeve.aigou.tests;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import top.jloeve.aigou.domains.impl.SearchHistory;
import top.jloeve.aigou.mappers.SearchHistoryMapper;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestSearchHistoryMapper extends TestCase {
  @Autowired private SearchHistoryMapper searchHistoryMapper;

  @Test
  public void TestQuery() {
    assertEquals(0, searchHistoryMapper.query(false, false, 0).size());
    assertTrue(searchHistoryMapper.query(false, false, null).size() > 0);

    List<SearchHistory> result;

    result = searchHistoryMapper.query(true, false, 2);
    assertEquals(2, result.size());
    assertTrue(result.get(0).getNum() > result.get(1).getNum());

    result = searchHistoryMapper.query(false, true, 2);
    assertEquals(2, result.size());
    assertTrue(result.get(0).getSearchTime().after(result.get(1).getSearchTime()));
  }
}
