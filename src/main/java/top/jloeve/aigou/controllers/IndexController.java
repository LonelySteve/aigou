package top.jloeve.aigou.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import top.jloeve.aigou.domains.impl.Carousel;
import top.jloeve.aigou.domains.impl.Product;
import top.jloeve.aigou.domains.impl.ProductType;
import top.jloeve.aigou.domains.impl.SearchHistory;
import top.jloeve.aigou.services.ICarouselService;
import top.jloeve.aigou.services.IProductService;
import top.jloeve.aigou.services.ISearchHistoryService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("")
public class IndexController {

  private final ISearchHistoryService searchHistoryService;

  private final IProductService productService;

  private final ICarouselService carouseService;

  @Autowired
  public IndexController(
      ISearchHistoryService searchHistoryService,
      IProductService productService,
      ICarouselService carouseService) {
    this.searchHistoryService = searchHistoryService;
    this.productService = productService;
    this.carouseService = carouseService;
  }

  @RequestMapping("")
  public String index(ModelMap modelMap) {
    List<SearchHistory> recentSearchHistories =
        searchHistoryService.getRecentPopularSearchHistories(6);
    modelMap.addAttribute("searchHistories", recentSearchHistories);

    List<ProductType> allProductTypes = productService.getAllProductTypes();
    modelMap.addAttribute("allProductTypes", allProductTypes);

    List<Carousel> carousels = carouseService.getCarousels(3);
    modelMap.addAttribute("allCarouselFigures", carousels);

    List<Product> newProducts = productService.getNewProducts(6);
    modelMap.addAttribute("newProducts", newProducts);

    List<Product> rankingProducts = productService.getRankingProducts(6);
    modelMap.addAttribute("rankings", rankingProducts);

    Map<String, Integer> partitionNameToCountMap = new HashMap<>();
    partitionNameToCountMap.put("全球进口", 5);
    partitionNameToCountMap.put("护肤美妆", 5);
    partitionNameToCountMap.put("服装服饰", 12);
    partitionNameToCountMap.put("图书学习", 12);

    int counter = 1;
    for (Map.Entry<String, Integer> entry : partitionNameToCountMap.entrySet()) {
      List<Product> products =
          productService.getByProductTypeName(entry.getKey(), entry.getValue());
      modelMap.addAttribute("list" + counter, products);
      counter++;
    }

    return "index/index";
  }
}
