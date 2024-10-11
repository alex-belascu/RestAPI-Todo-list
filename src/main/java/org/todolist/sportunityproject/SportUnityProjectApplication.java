package org.todolist.sportunityproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"controllers", "services", "models"})
public class SportUnityProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportUnityProjectApplication.class, args);
	}

}


