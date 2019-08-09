package library.thrift_service.client;

import com.alibaba.fastjson.JSONObject;
import library.thrift_service.ThriftService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import java.util.HashMap;
import java.util.Map;

public class ThriftClient {
  private static final String SERVER_IP = "localhost";
  private static final int SERVER_PORT = 9090; // Thrift server listening port
  private static final int TIMEOUT = 3000;

  public void startClient(String body) {
    TTransport transport = null;
    try {
      transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
      // 协议要和服务端一致
      TProtocol protocol = new TBinaryProtocol(transport);
      ThriftService.Client client = new ThriftService.Client(protocol);
      transport.open();

      System.out.println(client.call(body));
    } catch (TException e) {
      e.printStackTrace();
    } finally {
      if (null != transport) {
        transport.close();
      }
    }
  }
}
