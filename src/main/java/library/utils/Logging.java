package library.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logging {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public Logger getLogger() {
    return this.logger;
  }
}
