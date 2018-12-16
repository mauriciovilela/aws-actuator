package com.hibicode.beerstore;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@EnableAdminServer
@SpringBootApplication
@PropertySource("classpath:build-info.properties")
public class BeerstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeerstoreApplication.class, args);
	}

}
