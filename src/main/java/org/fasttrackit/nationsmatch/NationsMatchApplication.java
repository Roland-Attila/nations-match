package org.fasttrackit.nationsmatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication (exclude = { SecurityAutoConfiguration.class })
public class NationsMatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(NationsMatchApplication.class, args);
	}

}
