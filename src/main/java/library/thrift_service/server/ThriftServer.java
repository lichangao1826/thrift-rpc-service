package library.thrift_service.server;

import library.thrift_service.ThriftService;
import library.thrift_service.ThriftServiceImpl;
import library.utils.Logging;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportFactory;
import org.slf4j.Logger;

public class ThriftServer {

  private static Logger logger = new Logging().getLogger();

  public void startServer(Integer port) {

    ThriftService.Processor processor =
        new ThriftService.Processor<ThriftService.Iface>(new ThriftServiceImpl());
    try {
      TServerTransport transport = new TServerSocket(port);
      TThreadPoolServer.Args tArgs = new TThreadPoolServer.Args(transport);
      tArgs.processor(processor);
      tArgs.protocolFactory(new TBinaryProtocol.Factory());
      tArgs.transportFactory(new TTransportFactory());
      tArgs.minWorkerThreads(200);
      tArgs.maxWorkerThreads(1000);
      TServer server = new TThreadPoolServer(tArgs);
      server.serve();
    } catch (Exception e) {
      logger.error("thrift服务启动失败", e);
    }
  }
}
