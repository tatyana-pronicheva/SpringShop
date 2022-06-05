package ru.gb.SpringShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringShopApplication {

	public static void main(String[] args) {
		PrepareDataApp.prepareData();
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		SpringApplication.run(SpringShopApplication.class, args);
	}

}
