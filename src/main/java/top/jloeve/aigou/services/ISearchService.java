package top.jloeve.aigou.services;

public interface ISearchService<T> extends IService {
  T getByParams(String productTypeUUID, String[] brands, String keyword);

  String getSearchAttributeName();
}
