import library.thrift_service.server.ThriftServer;

public class Server {
  public static void main(String[] args) {
    ThriftServer server = new ThriftServer();
    server.startServer(9090);
  }
}
