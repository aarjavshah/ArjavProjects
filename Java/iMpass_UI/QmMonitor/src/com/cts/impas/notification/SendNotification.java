package com.cts.impas.notification;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendNotification {
	public static void SendEmail(EmailTemplateBO bo) throws AddressException, MessagingException, UnsupportedEncodingException{
		
		final String username = "noreply.impas@gmail.com";
		final String password = "sadarjav";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

			
			Message message = new MimeMessage(session);
			//Address mail[] = new InternetAddress[1];
//			message.setFrom(new InternetAddress(username,"Unknown"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(bo.getToEmail()));
			message.setSubject(bo.getSubject());
			message.setText(bo.getMsgBody());
			Transport.send(message);
		
	}

}
