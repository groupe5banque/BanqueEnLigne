package dto;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaEmail {

	Properties emailProperties;
	Session mailSession;
	MimeMessage emailMessage;

	String emailHost = "smtp.gmail.com";
	String emailPort = "587";
	String fromUser = "banques8.5@gmail.com";
	String fromUserEmailPassword = "banqueenligne";
	String[] toEmails = { "banques8.5@gmail.com" };

	public void setMailServerProperties() {
		emailProperties = System.getProperties();
		emailProperties.put("mail.smtp.port", emailPort);
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.smtp.starttls.enable", "true");
		
		emailProperties.put("mail.smtp.host", "smtp.gmail.com");
        emailProperties.put("mail.smtp.socketFactory.port", "587");
        emailProperties.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        emailProperties.put("mail.smtp.auth", "true");
        emailProperties.put("mail.smtp.port", "587");

        
	}

	public void createEmailMessage(String emailSubject, String emailBody)
			throws AddressException, MessagingException {
		mailSession = Session.getDefaultInstance(emailProperties, null);
		emailMessage = new MimeMessage(mailSession);
		for (int i = 0; i < toEmails.length; i++) {
			emailMessage.addRecipient(Message.RecipientType.TO,
					new InternetAddress(toEmails[i]));
		}
		emailMessage.setSubject(emailSubject);
		emailMessage.setContent(emailBody, "text/html");// for a html email
		// emailMessage.setText(emailBody);// for a text email

	}

	public void sendEmail() throws AddressException, MessagingException {
		Transport transport = mailSession.getTransport("smtp");
		transport.connect(emailHost, fromUser, fromUserEmailPassword);
		transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
		transport.close();
	}
	
	/*public static void main(String[] args) throws AddressException, MessagingException{
	
		String message = null;
		String status = null;
		
		JavaEmail javaEmail = new JavaEmail();
		javaEmail.setMailServerProperties();
		String emailSubject = " Java JSP GMail";
		String emailBody = "";
		

		javaEmail.createEmailMessage(emailSubject, emailBody);
		
		try {
			javaEmail.sendEmail();
			status = "success";
			message = "Email sent Successfully!";
		} catch (MessagingException me) {
			status = "error";
			message = "Error in Sending Email!";
			me.printStackTrace();
		}
	
		if (null != message) {
			System.out.println(status + " "
					+ message );
		}
		}*/
	
}