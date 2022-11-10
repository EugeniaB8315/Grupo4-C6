package com.grupo4.hotels.service;

import com.grupo4.hotels.dto.Attribute.GetAttributeDTO;
import com.grupo4.hotels.dto.Image.CreateImageDTO;
import com.grupo4.hotels.dto.Image.GetImagesDTO;
import com.grupo4.hotels.dto.Product.CreateProductDto;
import com.grupo4.hotels.dto.Product.GetProductCardDto;
import com.grupo4.hotels.exception.ResourceNotFoundException;
import com.grupo4.hotels.model.Attribute;
import com.grupo4.hotels.model.Category;
import com.grupo4.hotels.model.Image;
import com.grupo4.hotels.model.Product;
import com.grupo4.hotels.repository.CategoryRepository;
import com.grupo4.hotels.repository.CityRepository;
import com.grupo4.hotels.repository.ImageRepository;
import com.grupo4.hotels.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private ImageService imageService;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    public ResponseEntity<Optional<Product>> find(Integer id) {
//        if (productRepository.findById(id).isPresent()) {
//            return ResponseEntity.ok(productRepository.findById(id));
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    public Product findById(Integer Id) {
        return productRepository.findById(Id).orElse(null);
    }


    public GetProductCardDto findByIdCard(Integer id) throws ResourceNotFoundException {
        GetProductCardDto productoDTO = new GetProductCardDto();
        if (productRepository.findById(id).isPresent()) {
            Product product = productRepository.findById(id).get();
            productoDTO.setId(product.getId());
            productoDTO.setTitle(product.getTitle());
            productoDTO.setDescription((product.getDescription()));
            productoDTO.setUrl_image(product.getUrl_main_image());
            productoDTO.setCategory_name(product.getCategory().getTitle());
            productoDTO.setCity_name(product.getCity().getTitle());
            productoDTO.setIdCity(product.getCity().getId());
            productoDTO.setIdCategory(product.getCategory().getId());
            productoDTO.setImages(product.getImages());
            productoDTO.setAttributes(product.getProductAttribute());
        } else {
            throw new ResourceNotFoundException("City not found");
        }

        return productoDTO;
    }


    public List<GetProductCardDto> findAll() {
        List<GetProductCardDto> productsDTO = new ArrayList<>();
        List<Product> products = productRepository.findAllRandom();

        for (Product product : products) {
            //product= products.get(i);
            GetProductCardDto productDTO = new GetProductCardDto();
            productDTO.setId(product.getId());
            productDTO.setTitle(product.getTitle());
            productDTO.setDescription((product.getDescription()));
            productDTO.setUrl_image(product.getUrl_main_image());
            productDTO.setCategory_name(product.getCategory().getTitle());
            productDTO.setCity_name(product.getCity().getTitle());
            productDTO.setIdCity(product.getCity().getId());
            productDTO.setIdCategory(product.getCategory().getId());
//            productDTO.setImages(product.getImages());
            productDTO.setAttributes(product.getProductAttribute());
            productsDTO.add(productDTO);
        }
        return productsDTO;
    }

    public List<GetProductCardDto> findCardsByCategory(Integer id_category) throws ResourceNotFoundException {
        List<Product> products = new ArrayList<>();
        List<GetProductCardDto> productsDTO = new ArrayList<>();
        if (categoryRepository.findById(id_category).isPresent()) {
            Category category = categoryRepository.findById(id_category).get();

            products = category.getProducts();

            for (Product product : products) {
                GetProductCardDto productoDTO = new GetProductCardDto();
                //product= products.get(i);
                productoDTO.setId(product.getId());
                productoDTO.setTitle(product.getTitle());
                productoDTO.setDescription((product.getDescription()));
                productoDTO.setUrl_image(product.getUrl_main_image());
                productoDTO.setCategory_name(product.getCategory().getTitle());
                productoDTO.setCity_name(product.getCity().getTitle());
                productoDTO.setIdCity(product.getCity().getId());
                productoDTO.setIdCategory(product.getCategory().getId());
//                productoDTO.setImages(product.getImages());
                productoDTO.setAttributes(product.getProductAttribute());
                productsDTO.add(productoDTO);
            }
        }
        return productsDTO;

    }

}