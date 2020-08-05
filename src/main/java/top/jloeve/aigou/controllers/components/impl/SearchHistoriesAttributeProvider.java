package top.jloeve.aigou.controllers.components.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.jloeve.aigou.controllers.components.IAttributeProvider;
import top.jloeve.aigou.domains.impl.SearchHistory;
import top.jloeve.aigou.services.ISearchHistoryService;

import java.util.List;
import java.util.Map;

@Component("searchHistories")
public class SearchHistoriesAttributeProvider implements IAttributeProvider {
  private final ISearchHistoryService searchHistoryService;

  @Autowired
  public SearchHistoriesAttributeProvider(ISearchHistoryService searchHistoryService) {
    this.searchHistoryService = searchHistoryService;
  }

  @Override
  public Map<String, Object> getAttributes(Map<String, Object> attrs) {
    List<SearchHistory> searchHistories = searchHistoryService.getRecentPopularSearchHistories();
    attrs.put("searchHistories", searchHistories);
    return attrs;
  }
}
