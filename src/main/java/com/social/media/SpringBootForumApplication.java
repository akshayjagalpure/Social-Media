package com.social.media;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

// You can also use this annotation to scan all mapper files on the configuration class.
// But this project, based on the principle of learning, choose to add @mapper annotations to each mapper class.
//@MapperScan("com.socialMedia.persistence.dao")
@EnableAsync
@SpringBootApplication
public class SpringBootForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootForumApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
//		sessionLocaleResolver.setDefaultLocale(Locale.CHINA);
		sessionLocaleResolver.setDefaultLocale(Locale.ENGLISH);
		return sessionLocaleResolver;
	}

}