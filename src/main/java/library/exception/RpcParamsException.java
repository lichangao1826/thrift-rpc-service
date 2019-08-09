package library.exception;

public class RpcParamsException extends BaseException {
  public RpcParamsException() {
    super();
  }

  public RpcParamsException(String message, Throwable cause) {
    super(message, cause);
  }

  public RpcParamsException(String message) {
    super(message);
  }

  public RpcParamsException(Throwable cause) {
    super(cause);
  }
}
