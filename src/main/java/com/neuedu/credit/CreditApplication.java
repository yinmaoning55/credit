package com.neuedu.credit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.util.Date;
import java.util.TimeZone;
/*//关闭security
@SpringBootApplication( exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})*/
@SpringBootApplication
@EnableCaching
public class CreditApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditApplication.class, args);
		System.out.println(TimeZone.getDefault());
	}
}
