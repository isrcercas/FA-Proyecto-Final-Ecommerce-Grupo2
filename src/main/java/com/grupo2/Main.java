package com.grupo2;

import com.grupo2.repositories.CategoriaRepository;
import com.grupo2.repositories.ProductoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {


		ApplicationContext spring = SpringApplication.run(Main.class, args);
		//ProductoRepository productoRepository = spring.getBean(ProductoRepository.class);
		//CategoriaRepository categoriaRepository = spring.getBean(CategoriaRepository.class);
		System.out.println("Inicializando Spring");

		System.out.println("Empezando a meter cosas");

	}
}
