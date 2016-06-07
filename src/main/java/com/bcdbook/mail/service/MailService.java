package com.bcdbook.mail.service;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.bcdbook.mail.pojo.Mail;

public class MailService {
	public String sendEmail(Mail mail) throws MessagingException, UnsupportedEncodingException{
		// 配置发送邮件的环境属性
        final Properties props = new Properties();
        // 表示SMTP发送邮件，需要进行身份验证
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", mail.getHost());
        // 发件人的账号
        props.put("mail.user", mail.getUsername());
        // 访问SMTP服务时需要提供的密码
        props.put("mail.password", mail.getPassword());

        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        
        // 设置发件人
        InternetAddress from = new InternetAddress(mail.getUsername(), mail.getNickName());
        message.setFrom(from);
        
        //设置sender
//        InternetAddress sender = new InternetAddress(mail.getSender());
//        message.setSender(sender);
        
        // 设置收件人
        InternetAddress to = new InternetAddress(mail.getReceiver());
        message.setRecipient(RecipientType.TO, to);

//        // 设置抄送
//        InternetAddress cc = new InternetAddress("xianforwork@163.com");
//        message.setRecipient(RecipientType.CC, cc);
//
//        // 设置密送，其他的收件人不能看到密送的邮件地址
//        InternetAddress bcc = new InternetAddress("952870487@qq.com");
//        message.setRecipient(RecipientType.CC, bcc);

        // 设置邮件标题
        message.setSubject(mail.getSubject());

        //设置简介文字
        message.setText(mail.getText());
        
        // 设置邮件的内容体
        message.setContent(mail.getContent(), "text/html;charset=UTF-8");

        // 发送邮件
        Transport.send(message);
		return "success";
	}
	
	public String sendEmail(String to,String subject,String text,String content){
		Mail mail = new Mail();
		mail.setHost("smtp.163.com");
		mail.setSender("xianforwork@163.com");
		mail.setNickName("BcdBook");
		mail.setUsername("bcdbook@163.com");
		mail.setPassword("li95287048");
		
		mail.setReceiver(to);
		mail.setSubject(subject);
		mail.setText(text);
		mail.setContent(content);
		
		try {
			sendEmail(mail);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void main(String[] args) {
//		public String host;//服务器地址
//		public String sender;//发件人的邮箱
//		public String receiver;//收件人的邮箱
//		public String nickName;//发件人的昵称
//		public String username;//发件的服务器账号(用于发送的邮箱)
//		public String password;//发件的服务器的密码(用于验证)
//		public String subject;//主题
//		public String text;//简介信息
//		public String content;//邮件主体内容
		
//		Mail mail = new Mail();
//		mail.setHost("smtp.163.com");
//		mail.setSender("xianforwork@163.com");
//		mail.setReceiver("lixian13149999@163.com");
//		mail.setNickName("nickName");
//		mail.setUsername("bcdbook@163.com");
//		mail.setPassword("li95287048");
//		mail.setSubject("邮件主题");
//		mail.setText("邮件简介信息");
//		mail.setContent("<a href=\"strom.bcdbook.com\">邮件的主体信息</a>");
//		
//		MailService ms = new MailService();
//		try {
//			ms.sendEmail(mail);
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
		
		MailService ms = new MailService();
		ms.sendEmail("xianforwork@163.com", "Bcdbook验证", "text信息", null);
	}
}
