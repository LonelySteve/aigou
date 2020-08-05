package top.jloeve.aigou.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.jloeve.aigou.domains.impl.Product;
import top.jloeve.aigou.domains.impl.ProductType;
import top.jloeve.aigou.services.IProductService;

import java.util.List;

@Controller
@RequestMapping("/product-detail")
public class ProductDetailPageController extends BaseController {
  private final IProductService productService;

  public ProductDetailPageController(IProductService productService) {
    this.productService = productService;
  }

  @Override
  public String[] getAttributeProviderNames() {
    return new String[] {"allProductTypes", "searchHistories"};
  }

  @RequestMapping("{uuid}")
  public String index(ModelMap modelMap, @PathVariable("uuid") String uuid) {
    mergeInheritedAttributes(modelMap);

    Product product = productService.getByUUID(uuid);
    modelMap.addAttribute("product", product);

    ProductType type = product.getType();
    List<Product> products = productService.getByProductTypeName(type.getName(), 6);
    modelMap.addAttribute("list", products);

    return "product_detail";
  }
}
