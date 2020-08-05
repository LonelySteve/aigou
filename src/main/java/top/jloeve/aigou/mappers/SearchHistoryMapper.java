package top.jloeve.aigou.mappers;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.jloeve.aigou.domains.impl.SearchHistory;

import java.util.List;

@Repository
public interface SearchHistoryMapper {
  List<SearchHistory> query(
      @Param("bySearchCount") boolean bySearchCount,
      @Param("byRecent") boolean byRecent,
      @Param("limit") Integer limit);
  boolean updateSearchHistoryCount(String keyword);
}
