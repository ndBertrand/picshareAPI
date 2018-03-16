package com.picshare.PicshareProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class PicshareProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PicshareProjectApplication.class, args);
	}
}
