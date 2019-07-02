package org.afmejia.photoapp.api.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PhotoAppApiUsers {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppApiUsers.class, args);
	}

}
