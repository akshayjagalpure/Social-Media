package com.social.media.event;

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

@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {

	private static final String VERIFICATION_EMAIL_FROM_ADDR = "springbootforum@163.com";

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
		email.setTo(user.getEmail());

		// send email asynchronously
		// this.emailService.sendEmail(email);
	}
}
