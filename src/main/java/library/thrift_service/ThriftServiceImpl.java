package library.thrift_service;

import com.alibaba.fastjson.JSONObject;
import library.exception.RpcParamsException;
import library.utils.Error;
import library.utils.Logging;
import library.utils.Utils;
import org.slf4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class ThriftServiceImpl implements ThriftService.Iface {

  private static Logger logger = new Logging().getLogger();

  @Override
  public String call(String body) {
    Map<String, Object> response;

    try {
      long startTime = System.currentTimeMillis();
      response = this.processCall(body);
      long endTime = System.currentTimeMillis();
      logger.info("incoming:{} {}s", body, (float) (endTime - startTime) / 1000);
    } catch (Exception e) {
      response = Error.getError(e.toString(), Error.DEFAULT_ERROR);
      logger.error("incoming:{} {}", body, e.toString());
    }

    return new JSONObject(response).toString();
  }

  @SuppressWarnings("unchecked")
  private Map<String, Object> processCall(String body) {

    JSONObject obj, authObj, requestData;

    try {
      obj = JSONObject.parseObject(body);
    } catch (com.alibaba.fastjson.JSONException e) {
      throw new RpcParamsException(String.format("参数错误:%s:%s", body, "json格式错误"));
    }

    try {
      requestData = obj.getJSONObject("request_data");
    } catch (Exception e) {
      throw new RpcParamsException(String.format("参数错误:%s:%s", body, "缺少request_data信息"));
    }

    String path;
    Map<String, Object> params, result;

    try {
      path = requestData.getString("url");
    } catch (Exception e) {
      throw new RpcParamsException(String.format("参数错误:%s:%s", body, "缺少path"));
    }

    try {
      params = JSONObject.toJavaObject(requestData.getJSONObject("params"), Map.class);
    } catch (Exception e) {
      throw new RpcParamsException(String.format("参数错误:%s:%s", body, "缺少params"));
    }

    try {
      result = this.callMethod(path, params);
    } catch (Exception e) {
      throw new RpcParamsException(String.format("参数错误:%s:%s", body, e.toString()));
    }

    return result;
  }

  @SuppressWarnings("unchecked")
  private Map<String, Object> callMethod(String path, Map<String, Object> params)
      throws ClassNotFoundException, NoSuchMethodException, InstantiationException,
          IllegalAccessException, InvocationTargetException, RuntimeException {
    Map<String, String> parsePath = Utils.parseRequestPath(path);

    Class<?> clazz = Class.forName(parsePath.get("class_path"));
    Method method = clazz.getMethod(parsePath.get("method"), Map.class);

    return JSONObject.parseObject(
        JSONObject.toJSONString(method.invoke(clazz.newInstance(), params)), Map.class);
  }
}
