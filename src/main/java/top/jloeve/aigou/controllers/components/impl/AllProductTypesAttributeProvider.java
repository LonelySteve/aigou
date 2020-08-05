package top.jloeve.aigou.controllers.components.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.jloeve.aigou.controllers.components.IAttributeProvider;
import top.jloeve.aigou.domains.impl.ProductType;
import top.jloeve.aigou.services.IProductService;

import java.util.List;
import java.util.Map;

@Component("allProductTypes")
public class AllProductTypesAttributeProvider implements IAttributeProvider {
  private final IProductService productService;

  @Autowired
  public AllProductTypesAttributeProvider(IProductService productService) {
    this.productService = productService;
  }

  @Override
  public Map<String, Object> getAttributes(Map<String, Object> attrs) {
    List<ProductType> allProductTypes = productService.getAllProductTypes();
    attrs.put("allProductTypes", allProductTypes);
    return attrs;
  }
}
