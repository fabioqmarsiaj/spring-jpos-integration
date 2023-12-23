package com.fabioqmarsiaj.springjposintegration;

import org.jpos.q2.Q2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJposIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJposIntegrationApplication.class, args);
		new Q2(args).start();
	}
}
