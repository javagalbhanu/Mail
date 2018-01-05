package q;

import java.io.FileInputStream;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

class UNPW extends Authenticator{
	public PasswordAuthentication getPasswordAuthentication() {
		
		return new PasswordAuthentication("email","password");
	}
}
public class SendMail {
	public static void main( String args[] ) throws Exception{
		  Properties p = new Properties();
		  p.load(new FileInputStream("./mailconfig.properties")); 
		  Session session = Session.getInstance(p,new UNPW());
		  
		  MimeMessage mail = new MimeMessage(session);
		  InternetAddress to = new InternetAddress("javagalbhanu@gmail.com");
		  mail.addRecipient(RecipientType.TO,to);
		  mail.setSubject("Test Mail");
		  mail.setText("Hi");
	      Transport.send(mail);
	  	} 
}


