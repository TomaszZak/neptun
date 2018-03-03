package com.tzak.neptun;

import com.tzak.neptun.common.DatabaseHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//@EnableScheduling
@SpringBootApplication
public class NeptunApplication {

	public static String APPLICATION_PATH = System.getProperty("user.dir");

	public static void main(String[] args) {

		SpringApplication.run(NeptunApplication.class, args);
	}
}
