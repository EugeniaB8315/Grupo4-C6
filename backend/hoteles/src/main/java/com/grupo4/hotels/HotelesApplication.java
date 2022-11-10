package com.grupo4.hotels;



import com.grupo4.hotels.model.Category;
import com.grupo4.hotels.model.City;
import com.grupo4.hotels.model.Product;
import com.grupo4.hotels.repository.CategoryRepository;
import com.grupo4.hotels.repository.CityRepository;
import com.grupo4.hotels.repository.ProductAttributeRepository;
import com.grupo4.hotels.repository.ProductRepository;
import com.grupo4.hotels.service.CityService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class HotelesApplication {

	public static void main(String[] args) {
		//SpringApplication.run(HotelesApplication.class, args);

		ApplicationContext context =SpringApplication.run(HotelesApplication.class, args);

		//System.out.println(context.getBean(ProductRepository.class).findAll());

		Optional ciudad=context.getBean(CityRepository.class).findById((1));

		City ciudad1= (City) ciudad.get();

		Optional categoria=context.getBean(CategoryRepository.class).findById((1));

		Category category1= (Category) categoria.get();

		//Product Producto1= new Product("primer producto",category1,ciudad1,"url");

		//System.out.println((Producto1));
		//System.out.println(context.getBean(ProductRepository.class).findByCity(ciudad1));

		//System.out.println(context.getBean(ProductRepository.class).findById((1)));
		Product Producto2= context.getBean(ProductRepository.class).findById(1).orElse(null);
		//System.out.println(context.getBean(ProductRepository.class).findAttributes(Producto2));
		System.out.println(context.getBean(ProductAttributeRepository.class).findAll());

	}

}
