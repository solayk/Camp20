package reservation.others;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	
	String recipient;
	String subject;
	String body;
	
	String host = "smtp.naver.com";  
	String username = "kimykarsenal";  
	String password = "rladudrnjs20!";  
	
	public SendMail() {
	}
	
	public void send_pw(String name, String email, String pw) {
		
		recipient = email;   
		subject = "감성캠핑입니다.";  
		body = "\r\n" +
			   " 안녕하세요.\r\n" +
			   " 감성캠핑입니다.\r\n" +
			   " " + name + " 회원님의 비밀번호는 " + pw + " 입니다.\r\n" +
			   " 감사합니다. \r\n"
			   ;
		
		sending();
	}
	
	public void sending() {

		int port=465; 

		Properties props = System.getProperties();  
		// SMTP 서버 정보 설정  
		props.put("mail.smtp.host", host);  
		props.put("mail.smtp.port", port);  
		props.put("mail.smtp.auth", "true");  
		props.put("mail.smtp.ssl.enable", "true");  
		props.put("mail.smtp.ssl.trust", host);  

		//Session 생성  
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {  
		String un=username;  
		String pw=password;  
		protected javax.mail.PasswordAuthentication getPasswordAuthentication() {  
		return new javax.mail.PasswordAuthentication(un, pw);  
		}  
		});  

		session.setDebug(true); //for debug  
		Message mimeMessage = new MimeMessage(session); //MimeMessage 생성 
		try {
			mimeMessage.setFrom(new InternetAddress("kimykarsenal@naver.com"));
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} //발신자 셋팅 , 보내는 사람의 이메일주소를 한번 더 입력합니다. 이때는 이메일 풀 주소를 다 작성해주세요.  

		try {
			mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} //수신자셋팅  

		try {
			mimeMessage.setSubject(subject);
		} catch (MessagingException e) {
			e.printStackTrace();
		} //제목셋팅  

		try {
			mimeMessage.setText(body);
		} catch (MessagingException e) {
			e.printStackTrace();
		} //내용셋팅 

		try {
			Transport.send(mimeMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		} //javax.mail.Transport.send() 이용 
	}
	
}
