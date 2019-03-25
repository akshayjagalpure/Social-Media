package com.social.media.event;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

import com.social.media.persistence.dao.UserMapper;
import com.social.media.persistence.dao.VerificationTokenMapper;
import com.social.media.persistence.model.User;
import com.social.media.persistence.model.VerificationToken;
import com.social.media.util.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.*;

@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {

	private static final String VERIFICATION_EMAIL_FROM_ADDR = "datta@gmail.com";

	private static final String VERIFICATION_EMAIL_SUBJECT = "User registration confirmation";

	private static final String CONFIRM_ENDPOINT = "registration-confirm";

	private static final Logger logger = LoggerFactory.getLogger(RegistrationListener.class);

	@Autowired
	private VerificationTokenMapper verificationTokenMapper;

	@Autowired
	private EmailService emailService;

	@Autowired
	private UserMapper userMapper;

	// root URL of service
	@Value("${service.url}")
	private String serviceUrl;

	@Override
	public void onApplicationEvent(final OnRegistrationCompleteEvent event) {
		this.confirmRegistration(event);
	}

	private void confirmRegistration(final OnRegistrationCompleteEvent event) {
		logger.info("confirmRegistration() >> " + event);
		String username = event.getUsername();
		this.createUserVerificationToken(username);
	}

	private void createUserVerificationToken(String username) {
		String token = UUID.randomUUID().toString(); // token string
		User user = this.userMapper.findByUsername(username);
		VerificationToken verificationToken = new VerificationToken(user, token);
		this.verificationTokenMapper.save(verificationToken);

		// construct verification email
		SimpleMailMessage email = new SimpleMailMessage();

		// confirmation link in email
		String confirmationLink = serviceUrl + "/user/" + CONFIRM_ENDPOINT + "?token=" + token;
		System.out.println("confirmation link >> " + confirmationLink);
		email.setFrom(VERIFICATION_EMAIL_FROM_ADDR);
		email.setSubject(VERIFICATION_EMAIL_SUBJECT);
		email.setText(confirmationLink);
		System.out.println("confirmation link >> " + user.getEmail());
		email.setTo(user.getEmail());
		System.out.println("confirmation link >> " + user.getEmail());
		// send email asynchronously
		 //this.emailService.sendEmail(email);
		System.out.println("confirmation link >> " + email);

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("datta@gmail.com", "Datta@1995");
			}
		});
		Message msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress("datta@gmail.com", false));
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		try {
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("datta@gmail.com"));
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		try {
			msg.setSubject("Tutorials point email");
			msg.setContent("Tutorials point email", "text/html");
			msg.setSentDate(new Date());

			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent("Tutorials point email", "text/html");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			MimeBodyPart attachPart = new MimeBodyPart();

//		attachPart.attachFile("/var/tmp/image19.png");
//		multipart.addBodyPart(attachPart);
			msg.setContent(multipart);
			Transport.send(msg);
			System.out.println("confirmation link >> new  " + msg);

		} catch (MessagingException e) {
			e.printStackTrace();
		}




	}
}
