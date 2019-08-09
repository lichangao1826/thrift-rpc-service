package library.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.Security;
import java.util.Properties;

public class Mail {
  // 邮箱用户名
  private static String userName = "xxx";
  // 邮箱授权码(非邮箱登录密码)
  private static String password = "xxx";

  /**
   * 发送邮件
   *
   * @param email 要发送的邮箱地址
   * @param subject 邮件标题
   * @param emailMsg 邮件内容
   */
  public static void sendMail(String email, String subject, String emailMsg) {
    try {
      // 1.创建一个程序与邮件服务器会话对象 Session
      Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
      final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
      // 设置邮件会话参数
      Properties props = new Properties();
      // 邮箱的发送服务器地址
      props.setProperty("mail.smtp.host", "smtp.exmail.qq.com");
      props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
      props.setProperty("mail.smtp.socketFactory.fallback", "false");
      // 邮箱发送服务器端口,这里设置为465端口
      props.setProperty("mail.smtp.port", "465");
      props.setProperty("mail.smtp.socketFactory.port", "465");
      // 指定验证为true
      props.setProperty("mail.smtp.auth", "true");
      // 创建验证器
      Authenticator auth =
          new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
              return new PasswordAuthentication(userName, password);
            }
          };
      Session session = Session.getInstance(props, auth);

      // 2.创建一个Message，它相当于是邮件内容
      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress(userName, "thrift-rpc-service")); // 设置发送者
      message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(email)); // 设置发送方式与接收者
      message.setSubject(subject);
      message.setContent(emailMsg, "text/html;charset=utf-8");

      // 3.创建 Transport用于将邮件发送
      Transport.send(message);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
