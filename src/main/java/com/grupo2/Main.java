package com.grupo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {


		ApplicationContext spring = SpringApplication.run(Main.class, args);

		System.out.println("Inicializando Spring");



	}
}
