package top.jloeve.aigou.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jloeve.aigou.domains.impl.SearchHistory;
import top.jloeve.aigou.mappers.SearchHistoryMapper;
import top.jloeve.aigou.services.ISearchHistoryService;

import java.util.List;

@Service
public class SearchHistoryServiceImpl implements ISearchHistoryService {

  private final SearchHistoryMapper searchHistoryMapper;

  @Autowired
  public SearchHistoryServiceImpl(SearchHistoryMapper searchHistoryMapper) {
    this.searchHistoryMapper = searchHistoryMapper;
  }

  @Override
  public List<SearchHistory> getPopularSearchHistories(Integer limit) {
    return searchHistoryMapper.query(true, false, limit);
  }

  @Override
  public List<SearchHistory> getRecentSearchHistories(Integer limit) {
    return searchHistoryMapper.query(false, true, limit);
  }

  @Override
  public List<SearchHistory> getRecentPopularSearchHistories(Integer limit) {
    return searchHistoryMapper.query(true, true, limit);
  }
}
