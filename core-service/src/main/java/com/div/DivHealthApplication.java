package com.div;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@EnableEurekaClient
//@EnableCaching
public class DivHealthApplication {

	public static void main(String[] args) {
		SpringApplication.run(DivHealthApplication.class, args);
	}

}
