package library.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class Error {
  public static final int DEFAULT_ERROR = 40001;

  public static Map<String, Object> getError(String errMsg, Integer errCode) {
    Map<String, Object> result = new HashMap<>();

    result.put("code", errCode);
    result.put("message", errMsg);
    result.put("result", new HashMap<>());

    return result;
  }

  public static String getStackTrace(Exception e) {
    StringWriter sw = null;
    PrintWriter pw = null;
    try {
      sw = new StringWriter();
      pw = new PrintWriter(sw);
      e.printStackTrace(pw);
      pw.flush();
      sw.flush();
    } finally {
      if (sw != null) {
        try {
          sw.close();
        } catch (IOException e1) {
          e1.printStackTrace();
        }
      }
      if (pw != null) {
        pw.close();
      }
    }
    return sw.toString();
  }
}
