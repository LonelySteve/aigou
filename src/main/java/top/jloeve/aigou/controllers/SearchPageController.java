package top.jloeve.aigou.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.jloeve.aigou.services.*;
import top.jloeve.aigou.utils.StringUtils;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchPageController extends BaseController {
  private final List<ISearchService<?>> searchServices;
  private final ISearchHistoryService searchHistoryService;

  @Autowired
  public SearchPageController(
      List<ISearchService<?>> searchServices, ISearchHistoryService searchHistoryService) {
    this.searchServices = searchServices;
    this.searchHistoryService = searchHistoryService;
  }

  @Override
  public String[] getAttributeProviderNames() {
    return new String[] {"allProductTypes", "searchHistories"};
  }

  @RequestMapping("")
  public String index(
      ModelMap modelMap,
      @RequestParam(value = "product-type-uuid", required = false) String uuid,
      @RequestParam(value = "brands", required = false) String brandsString,
      @RequestParam(value = "keyword", required = false) String keyword) {
    mergeInheritedAttributes(modelMap);

    uuid = StringUtils.returnNullIfIsEmptyOrNull(uuid);
    keyword = StringUtils.returnNullIfIsEmptyOrNull(keyword);
    String[] brands = null;
    if (!StringUtils.isEmptyOrNull(brandsString)) brands = brandsString.split(",");

    for (ISearchService<?> searchService : searchServices) {
      Object result = searchService.getByParams(uuid, brands, keyword);
      modelMap.addAttribute(searchService.getSearchAttributeName(), result);
    }

    recordSearch(keyword);

    return "search_product";
  }

  private void recordSearch(String keyword) {
    if (StringUtils.isEmptyOrNull(keyword)) {
      return;
    }
    searchHistoryService.updateSearchHistoryCount(keyword);
  }
}
