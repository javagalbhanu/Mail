package q;

import java.io.FileInputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

class m2 extends Authenticator{
	@Override
	public PasswordAuthentication getPasswordAuthentication() {
		
		return new PasswordAuthentication("username","password");
	}
}

public class EmailWithAttachment {
	public static void main( String... aArguments ) throws Exception{
		  System.out.println("start");
		  Properties p = new Properties();
		  p.load(new FileInputStream("./mailconfig.properties")); 
		  Session session = Session.getInstance(p,new m2());
		  
		  MimeMessage message = new MimeMessage(session);
	      message.addRecipient(RecipientType.TO,new InternetAddress("javagalbhanu@gmail.com"));
	      message.setSubject("ayyo with  attachment");
	      message.setText("body");
	      
	      Multipart multipart = new MimeMultipart();
	      MimeBodyPart bp = new MimeBodyPart();
	      DataSource source = new FileDataSource("./mail.txt");
	      bp.setDataHandler(new DataHandler(source));
	      bp.setFileName("mail.txt");
	      multipart.addBodyPart(bp);
	      
	      message.setContent(multipart);
	      Transport.send(message);
	      System.out.println("Done");
	  	} 
}
