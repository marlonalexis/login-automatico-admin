package com.claro.loginautomaticocvideo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableCaching
@SpringBootApplication
@ComponentScan
@EnableTransactionManagement
public class LACVAdminApplication {
	public static void main(String[] args) {
		SpringApplication.run(LACVAdminApplication.class, args);
	}
}
