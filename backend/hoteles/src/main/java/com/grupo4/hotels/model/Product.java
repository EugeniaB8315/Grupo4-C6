package com.grupo4.hotels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_product")
    private Integer Id ;

    public Category getCategory() {
        return category;
    }

    private String title;


    @ManyToOne
    @JoinColumn(name="id_category")
    @JsonIgnore
    private Category category;

    @ManyToOne
    @JoinColumn(name="id_city")
    private City city;


    
    //@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    //private List<ProductAttribute> productAttribute = new ArrayList<>();


    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name="products_attributes",
            joinColumns = {
                @JoinColumn(name= "id_product",referencedColumnName = "id_product")
            },

            inverseJoinColumns = {
                @JoinColumn(name = "id_attribute", referencedColumnName = "id_attribute")
            }
    )
    @JsonManagedReference
    private List<Attribute> productAttribute = new ArrayList<>();

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Image> images = new ArrayList<>();


    private String url_main_image;

    private String description;


    public Product() {
    }

    public Product(String title, Category category, City city, List<Attribute> productAttribute, List<Image> images, String url_main_image, String description) {
        this.title = title;
        this.category = category;
        this.city = city;
        this.productAttribute = productAttribute;
        this.images = images;
        this.url_main_image = url_main_image;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public Integer getId() {
        return Id;
    }


    public City getCity() {
        return city;
    }

    public List<Attribute> getProductAttribute() {
        return productAttribute;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setProductAttribute(List<Attribute> productAttribute) {
        this.productAttribute = productAttribute;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getUrl_main_image() {
        return url_main_image;
    }

    public void setUrl_main_image(String url_main_image) {
        this.url_main_image = url_main_image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id_product=" + Id +
                ", title='" + title + '\'' +
                ", category=" + category.getTitle() +
                ", city=" + city.getTitle() +
                '}';
    }
}

