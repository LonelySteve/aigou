package top.jloeve.aigou.controllers.components;

import java.util.HashMap;
import java.util.Map;

public interface IAttributeProvider {
  default Map<String, Object> getAttributes() {
    return getAttributes(new HashMap<>());
  }

  Map<String, Object> getAttributes(Map<String, Object> attrs);
}
