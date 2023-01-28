package com.example.firstAppMete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstAppMeteApplication {

	public static void main(String[] args) {

		SpringApplication.run(FirstAppMeteApplication.class, args);

		Client client = new Client();
		PhoneResponseDto phoneResponseDto = client.verifyNumber();
		System.out.println(phoneResponseDto);
	}

}
