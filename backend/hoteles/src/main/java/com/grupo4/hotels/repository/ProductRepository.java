package com.grupo4.hotels.repository;

import com.grupo4.hotels.model.Category;
import com.grupo4.hotels.model.City;
import com.grupo4.hotels.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {


    // Para filtrar productos por ciudad
    @Query("from Product p where p.city= ?1")
    List<Product> findByCity(City city);

    @Query("from Product p where p.category= ?1")
    List<Product> findByCategory(Category category);

    @Query(value = "select * from products order by rand()",nativeQuery = true)
    List<Product> findAllRandom();

    //@Query("select product.productAttribute from Product product where product=?1 ")
    //List<ProductAttribute> findAttributes(Product product);
}
