import com.alibaba.fastjson.JSONObject;
import library.thrift_service.client.ThriftClient;

import java.util.HashMap;
import java.util.Map;

public class Client {
  public static void main(String[] args) {
    ThriftClient client = new ThriftClient();

    Map<String, Object> body = new HashMap<>();

    Map<String, Object> requestData = new HashMap<>();
    requestData.put("url", "/index/index/hello_world");

    Map<String, Object> params = new HashMap<>();
    params.put("name", "braincy");
    requestData.put("params", params);

    body.put("request_data", requestData);

    client.startClient(JSONObject.toJSONString(body));
  }
}
