package com.codelovin.springboot.sentrydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerExceptionResolver;

import io.sentry.Sentry;

@SpringBootApplication
public class SentryDemoApplication {

	/*
	 * SentryExceptionResolver sends all exceptions to Sentry and then defers all handling 
	 * to the other HandlerExceptionResolvers. You should only register this if you are not 
	 * using a logging integration, otherwise you may double report exceptions.
	 */
	@Bean
	public HandlerExceptionResolver sentryExceptionResolver() {
		return new io.sentry.spring.SentryExceptionResolver();
	}

	/*
	 * SentryServletContextInitializer installs the SentryServletRequestListener so that 
	 * Sentry events contain HTTP request information.
	 */
	@Bean
	public ServletContextInitializer sentryServletContextInitializer() {
		return new io.sentry.spring.SentryServletContextInitializer();
	}

	public static void main(String[] args) {
		Sentry.init();
		SpringApplication.run(SentryDemoApplication.class, args);
	}
}
