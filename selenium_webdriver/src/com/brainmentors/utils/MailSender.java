package com.brainmentors.utils;


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

import com.brainmentors.utils.templates.MailTemplate;

public interface MailSender {
	
	public static boolean sendMail(String filePath) throws AddressException, MessagingException {
		String msg = MailTemplate.getInfoTemplate();
		String userid = ConfigReader.getValue("mailusername");
		String pwd = ConfigReader.getValue("mailpassword");
		String host = ConfigReader.getValue("mailhost");
		String port = ConfigReader.getValue("mailport");
		// Config Mail Host 
		Properties mailProps = new Properties();
		mailProps.put("mail.smtp.auth", true);
		mailProps.put("mail.smtp.starttls.enable", true);
		mailProps.put("mail.smtp.host", host);
		mailProps.put("mail.smtp.port", port);
		
		//  Login Session
		Session session = Session.getInstance(mailProps, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(userid, pwd);
			}
		});
		
		// Subject, Content , From , to
		Message message  = new MimeMessage(session);
		message.setFrom(new InternetAddress("sender@gmail.com"));
		message.setRecipients(Message.RecipientType.TO, 
				InternetAddress.parse("rec@gmail.com"));
		
		message.setSubject("TEST MAIL");
		message.setText(msg);
		
		// Attachment
		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		Multipart multiPart = new MimeMultipart();
		String attachmentName = "brainmentors.jpg";
		FileDataSource source = new FileDataSource(filePath);
		mimeBodyPart.setDataHandler(new DataHandler(source));
		mimeBodyPart.setFileName(attachmentName);
		
		mimeBodyPart.setText(msg);
		multiPart.addBodyPart(mimeBodyPart);
		message.setContent(multiPart);
		
		// Send Mail
		Transport.send(message);
		System.out.println("Mail Send It");
		return true;
		
		
	}

}
