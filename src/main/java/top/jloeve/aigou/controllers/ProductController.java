package top.jloeve.aigou.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.jloeve.aigou.domains.impl.Product;
import top.jloeve.aigou.domains.impl.ProductType;
import top.jloeve.aigou.services.IProductService;
import top.jloeve.aigou.services.ISearchHistoryService;
import top.jloeve.aigou.services.ISearchService;
import top.jloeve.aigou.utils.StringUtils;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController extends BaseController {

  private final IProductService productService;
  private final List<ISearchService<?>> searchServices;
  private final ISearchHistoryService searchHistoryService;

  @Autowired
  public ProductController(
      IProductService productService,
      List<ISearchService<?>> searchServices,
      ISearchHistoryService searchHistoryService) {
    this.productService = productService;
    this.searchServices = searchServices;
    this.searchHistoryService = searchHistoryService;
  }

  @Override
  public String[] getAttributeProviderNames() {
    return new String[] {"allProductTypes", "searchHistories"};
  }

  @RequestMapping("/detail/{uuid}")
  public String detail(ModelMap modelMap, @PathVariable("uuid") String uuid) {
    mergeInheritedAttributes(modelMap);

    Product product = productService.getByUUID(uuid);
    modelMap.addAttribute("product", product);

    ProductType type = product.getType();
    List<Product> products = productService.getByProductTypeName(type.getName(), 6);
    modelMap.addAttribute("list", products);

    return "product/detail";
  }

  @RequestMapping("/search")
  public String search(
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

    if (!StringUtils.isEmptyOrNull(keyword)) {
      searchHistoryService.updateSearchHistoryCount(keyword);
    }

    return "product/search";
  }
}
