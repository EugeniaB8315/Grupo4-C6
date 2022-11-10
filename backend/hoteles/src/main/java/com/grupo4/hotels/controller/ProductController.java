package com.grupo4.hotels.controller;

import com.grupo4.hotels.dto.Product.CreateProductDto;
import com.grupo4.hotels.dto.Product.GetProductCardDto;
import com.grupo4.hotels.exception.ResourceNotFoundException;
import com.grupo4.hotels.model.Product;
import com.grupo4.hotels.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;


//    @GetMapping("/byCard")
//    public ResponseEntity<List<GetProductCardDto>> findAllByIdCard() throws ResourceNotFoundException {
//        return ResponseEntity.ok(productService.findAllByIdCard());
//    }

    @GetMapping
    public ResponseEntity<List<GetProductCardDto>> findAllB() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetProductCardDto> findById(@PathVariable Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(productService.findByIdCard(id));
    }

    @GetMapping("/productsByCatogry/{id}")
    public ResponseEntity<List<GetProductCardDto>> findCardsByCategory(@PathVariable Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(productService.findCardsByCategory(id));
    }

}








