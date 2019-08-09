package modules.Index.controllers;

import library.controller.BaseController;
import library.utils.Mail;
import library.utils.Utils;
import library.utils.Error;

import java.util.Map;

public class Index extends BaseController {

  public Map<String, Object> helloWorld(Map<String, Object> params) {

    try {
      String name = params.get("name").toString();

      String result = "Hello " + name;

      return Utils.showResult(result);
    } catch (Exception e) {
      logger.error("thrift rpc 测试失败", e);
      Mail.sendMail("xxx", "thrift rpc 测试失败", Error.getStackTrace(e));
      throw new RuntimeException(e);
    }
  }
}
