package com.justplay1994.github.unifiedauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class UnifiedAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnifiedAuthApplication.class, args);
	}
}
