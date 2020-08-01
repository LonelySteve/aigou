package top.jloeve.aigou.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jloeve.aigou.domains.impl.Carousel;
import top.jloeve.aigou.mappers.CarouselMapper;
import top.jloeve.aigou.services.ICarouselService;

import java.util.List;

@Service
public class CarouselServiceImpl implements ICarouselService {
  private final CarouselMapper carouselMapper;

  @Autowired
  public CarouselServiceImpl(CarouselMapper carouselMapper) {
    this.carouselMapper = carouselMapper;
  }

  @Override
  public List<Carousel> getCarousels(Integer limit) {
    return carouselMapper.query(limit);
  }
}
