package top.jloeve.aigou.services;

import top.jloeve.aigou.domains.impl.SearchHistory;

import java.util.List;

public interface ISearchHistoryService extends IService {

  default List<SearchHistory> getPopularSearchHistories() {
    return getPopularSearchHistories(null);
  }

  default List<SearchHistory> getRecentSearchHistories() {
    return getRecentSearchHistories(null);
  }

  default List<SearchHistory> getRecentPopularSearchHistories() {
    return getRecentPopularSearchHistories(null);
  }

  List<SearchHistory> getPopularSearchHistories(Integer limit);

  List<SearchHistory> getRecentSearchHistories(Integer limit);

  List<SearchHistory> getRecentPopularSearchHistories(Integer limit);
}
