package com.grupo2;

import com.grupo2.entities.Categoria;
import com.grupo2.repositories.CategoriaRepository;
import com.grupo2.repositories.ProductoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.converter.json.GsonBuilderUtils;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {


		ApplicationContext spring = SpringApplication.run(Main.class, args);

		System.out.println("Inicializando Spring");



	}
}
