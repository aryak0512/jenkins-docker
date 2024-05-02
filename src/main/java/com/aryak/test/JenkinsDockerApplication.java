package com.aryak.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@SpringBootApplication
@RestController
public class JenkinsDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JenkinsDockerApplication.class, args);
	}

	@GetMapping("/msg")
	public String getMessage(){
		return new Date().toString();
	}

}
