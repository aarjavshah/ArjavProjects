import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailTLS {

	public static void main(String[] args) throws UnsupportedEncodingException {

		final String username = "rtr.aarjav@gmail.com";
		final String password = "rtraarjavshah";

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

		try {

			
			Message message = new MimeMessage(session);
			Address mail[] = new InternetAddress[1];
			mail[0]= new InternetAddress("aarjavrocks@gmail.com");
			//message.setReplyTo(mail);
			message.setFrom(new InternetAddress(username,"Unknown"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("ankitzalavadiya@gmail.com"));
			message.setSubject("Chutiyo");
			message.setText("Landus,"
				+ "\n\n No spam to my email, please!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}