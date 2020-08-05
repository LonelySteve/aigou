package top.jloeve.aigou.mappers;

import org.apache.ibatis.annotations.Param;

public interface ISearchMapper<T> {
  T queryByParams(
      @Param("productTypeUUID") String productTypeUUID,
      @Param("brandUUIDs") String[] brandUUIDs,
      @Param("keyword") String keyword);
}
