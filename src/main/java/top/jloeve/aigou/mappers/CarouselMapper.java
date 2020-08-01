package top.jloeve.aigou.mappers;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.jloeve.aigou.domains.impl.Carousel;

import java.util.List;

@Repository
public interface CarouselMapper {
  List<Carousel> query(@Param("limit") Integer limit);
}
