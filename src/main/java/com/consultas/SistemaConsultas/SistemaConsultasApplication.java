package com.consultas.SistemaConsultas;

import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class SistemaConsultasApplication extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	private BCryptPasswordEncoder passwordEncode;
	public static void main(String[] args) throws ParseException {
		SpringApplication.run(SistemaConsultasApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		String password = "springboot";
		for (int i = 0; i<3;  i++) {
			String passwordBcrypt = passwordEncode.encode(password);
			System.out.println(passwordBcrypt);
		}
		
	}

    @Bean
    WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				System.out.println("Registry: "+ registry);
				registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:3000").allowCredentials(true)
				.allowedHeaders("Origin, X-Requested-With, Content-Type, Accept");
			}
		};
	}
}
