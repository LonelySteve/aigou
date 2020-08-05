package top.jloeve.aigou.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import top.jloeve.aigou.controllers.components.IAttributeProvider;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public abstract class BaseController {
  private Map<String, IAttributeProvider> attributeProviderMap;

  @Autowired
  public void setAttributeProviderMap(Map<String, IAttributeProvider> attributeProviderMap) {
    if (attributeProviderMap == null) {
      attributeProviderMap = new HashMap<>();
    }
    this.attributeProviderMap = attributeProviderMap;
  }

  public String[] getAttributeProviderNames() {
    return new String[] {};
  }

  public void mergeInheritedAttributes(ModelMap modelMap) {
    String[] attributeProviderNames = getAttributeProviderNames();
    List<IAttributeProvider> attributeProviders =
        Arrays.stream(attributeProviderNames)
            .map(name -> attributeProviderMap.getOrDefault(name, null))
            .collect(Collectors.toList());
    for (IAttributeProvider attributeProvider : attributeProviders) {
      attributeProvider.getAttributes(modelMap);
    }
  }
}
