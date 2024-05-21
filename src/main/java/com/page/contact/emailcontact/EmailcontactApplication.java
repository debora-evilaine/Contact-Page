package com.page.contact.emailcontact;

import com.page.contact.emailcontact.user.EndUser;
import com.page.contact.emailcontact.user.EndUserRepository;
import com.page.contact.emailcontact.user.EndUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication(scanBasePackages = {"com.page.contact.emailcontact", "com.page.contact.emailcontact.user.controllers", "src/main/resources/templates"})
public class EmailcontactApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailcontactApplication.class, args);
	}

}
