package com.tpddl.appiumtesting.utils;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.tpddl.appiumtesting.helpers.Command;

public class Mail {
	
	public static boolean sendMail(String screenShotPath, String mailIds, String msg) throws AddressException, MessagingException {
		// Mail Credentials
		String userid = PropertyReader.getValue(Constants.MAIL_USERID);
		String password = PropertyReader.getValue(Constants.MAIL_PWD);
		
		// Mail Config
		Properties mailProps = new Properties();
		mailProps.put("mail.smtp.auth",PropertyReader.getValue(Command.SMTP_AUTH));
		mailProps.put("mail.smtp.starttls.enable",PropertyReader.getValue(Command.SMTP_TLS));
		mailProps.put("mail.smtp.host",PropertyReader.getValue(Command.SMTP_HOST));
		mailProps.put("mail.smtp.port",PropertyReader.getValue(Command.SMTP_PORT));
		
		// Login and Create Session
		Session session = Session.getInstance(mailProps,new Authenticator() {
			@Override
			 protected PasswordAuthentication getPasswordAuthentication() {
				 return new PasswordAuthentication(userid, password);
			 }
		});
		
		// From , to , Subject, Message
		Message message = new MimeMessage(session);
		message.setFrom(InternetAddress.parse(userid)[0]);
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailIds));
		message.setSubject("ScreenShots of App");
		message.setText(msg);
		
		// Attachment
		
		Multipart multiPart = new MimeMultipart();
		
		MimeBodyPart txtMsgPart = new MimeBodyPart();
		txtMsgPart.setContent(msg, "text/html");
		
		String attachmentName="brainmentors.png";
		FileDataSource fs = new FileDataSource(screenShotPath);
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setFileName(attachmentName);
		messageBodyPart.setDataHandler(new DataHandler(fs));
		multiPart.addBodyPart(txtMsgPart);
		multiPart.addBodyPart(messageBodyPart);
		//messageBodyPart.setText(msg);
		message.setContent(multiPart);
		
		Transport.send(message);
		return true;
	}
	
	
	
	
	
	
	

}
