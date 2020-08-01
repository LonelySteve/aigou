package top.jloeve.aigou.services;

import top.jloeve.aigou.domains.impl.Carousel;

import java.util.List;

public interface ICarouselService extends IService {
  List<Carousel> getCarousels(Integer limit);
}
