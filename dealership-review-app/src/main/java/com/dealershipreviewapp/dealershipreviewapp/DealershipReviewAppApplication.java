package com.dealershipreviewapp.dealershipreviewapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class DealershipReviewAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DealershipReviewAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Probably add some dummy reviews here, to the review repository
		
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
