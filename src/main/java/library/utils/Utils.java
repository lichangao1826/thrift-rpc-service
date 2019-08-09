package library.utils;

import java.util.HashMap;
import java.util.Map;

public class Utils {

  /**
   * 解析请求
   *
   * @param path 请求 URL
   * @return 解析后的控制器路径及方法名
   */
  public static Map<String, String> parseRequestPath(String path) {
    String[] pathList = path.substring(1).split("/");

    String[] pathType = {"modules", "controllers"};
    StringBuilder classPath = new StringBuilder();
    String method = "";

    for (int i = 0; i < pathList.length; i++) {
      if (i < pathList.length - 1) {
        String s = classPath.length() == 0 ? "" : ".";
        s += pathType[i] + "." + underlineToHump(pathList[i], true);
        classPath.append(s);
      } else {
        method = underlineToHump(pathList[i], false);
      }
    }

    Map<String, String> result = new HashMap<>();
    result.put("class_path", classPath.toString());
    result.put("method", method);

    return result;
  }

  /**
   * 下划线字符串转驼峰
   *
   * @param para 需要转换的字符串
   * @param needUpper 驼峰字符串首字母是否大写
   * @return 转换后的驼峰字符串
   */
  private static String underlineToHump(String para, boolean needUpper) {
    StringBuilder result = new StringBuilder();
    String[] paraList = para.split("_");

    for (String s : paraList) {
      if ((result.length() == 0 && !needUpper) || (!para.contains("_") && !needUpper)) {
        result.append(s.toLowerCase());
      } else {
        result.append(s.substring(0, 1).toUpperCase());
        result.append(s.substring(1).toLowerCase());
      }
    }
    return result.toString();
  }

  /**
   * 方法返回数据格式化
   *
   * @param response 返回数据
   * @return 格式化后的数据
   */
  public static Map<String, Object> showResult(Object response) {
    Map<String, Object> result = new HashMap<>();

    result.put("status", 0);
    result.put("msg", "");
    result.put("result", response);

    return result;
  }
}
