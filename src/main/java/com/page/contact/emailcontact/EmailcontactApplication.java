package com.page.contact.emailcontact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.page.contact.emailcontact", "com.page.contact.emailcontact.user.controllers", "src/main/resources/templates"})
public class EmailcontactApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailcontactApplication.class, args);
	}

}
