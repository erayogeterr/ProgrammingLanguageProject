package com.programmingLanguage.programmingLanguage;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProgrammingLanguageApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgrammingLanguageApplication.class, args);
	}

	@Bean // Spring IoC container'ına bean olarak ekler.
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
