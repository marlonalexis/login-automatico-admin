package com.claro.loginautomaticocvideo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@EnableCaching
@SpringBootApplication
@ComponentScan
public class LACVGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(LACVGatewayApplication.class, args);
	}
}
