package com.rafael;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

@SpringBootApplication
public class MercadoriasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MercadoriasApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localresolver() {
		return new FixedLocaleResolver(new Locale("pt","BR"));
	}
}
