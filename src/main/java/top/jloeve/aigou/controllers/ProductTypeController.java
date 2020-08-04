package top.jloeve.aigou.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.jloeve.aigou.domains.impl.Brand;
import top.jloeve.aigou.domains.impl.Product;
import top.jloeve.aigou.domains.impl.ProductType;
import top.jloeve.aigou.services.IBrandService;
import top.jloeve.aigou.services.IProductService;
import top.jloeve.aigou.services.IProductTypeService;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping("/product-type")
public class ProductTypeController {

  private final IProductService productService;
  private final IProductTypeService productTypeService;
  private final IBrandService brandService;

  @Autowired
  public ProductTypeController(
      IProductService productService,
      IProductTypeService productTypeService,
      IBrandService brandService) {
    this.productService = productService;
    this.productTypeService = productTypeService;
    this.brandService = brandService;
  }

  @RequestMapping("")
  public String index(ModelMap modelmap, String uuid, String brands, String keyword) {
    // targetProductType
    ProductType productType = productTypeService.getById(uuid);
    modelmap.addAttribute("targetProductType", productType);
    // allProductTypes
    List<ProductType> allProductTypes = productTypeService.getAll();
    modelmap.addAttribute("allProductTypes", allProductTypes);
    // brands 符合指定条件的所有品牌
    List<Brand> allBrands = brandService.getByTypeId(uuid);
    modelmap.addAttribute("brands", allBrands);
    // products 符合指定条件的所有产品
    List<Product> products = productService.getByParams(uuid, brands, keyword);
    modelmap.addAttribute("products", products);

    return "product-type-page";
  }
}
