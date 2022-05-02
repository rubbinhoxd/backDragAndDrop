package com.rav_tecnologia.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController //bin do tipo controller
public class DesafioApplication {
	@RequestMapping("/")
	public String  teste() {
		return "Teste";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
		
		
		
	}

}
