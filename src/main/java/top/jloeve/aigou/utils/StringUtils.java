package top.jloeve.aigou.utils;

public class StringUtils {
  public static boolean isEmptyOrNull(String s) {
    return org.thymeleaf.util.StringUtils.isEmptyOrWhitespace(s);
  }

  public static String returnNullIfIsEmptyOrNull(String s) {
    if (isEmptyOrNull(s)) {
      return null;
    }
    return s;
  }
}
