package com.grupo4.hotels.dto.Product;

import com.grupo4.hotels.dto.Attribute.GetAttributeDTO;
import com.grupo4.hotels.dto.Image.CreateImageDTO;
import com.grupo4.hotels.dto.Image.GetImagesDTO;
import com.grupo4.hotels.model.Attribute;

import java.util.ArrayList;
import java.util.List;

public class CreateProductDto {
    private transient Integer id;
    private String title;
    private String description;
    private String url_image;
    private Integer idCategory;
    private Integer idCity;
    private List<CreateImageDTO> images = new ArrayList<>();
    private List<GetAttributeDTO> attributes = new ArrayList<>();

    public CreateProductDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public Integer getIdCity() {
        return idCity;
    }

    public void setIdCity(Integer idCity) {
        this.idCity = idCity;
    }

    public List<CreateImageDTO> getImages() {
        return images;
    }

    public void setImages(List<CreateImageDTO> images) {
        this.images = images;
    }

    public List<GetAttributeDTO> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<GetAttributeDTO> attributes) {
        this.attributes = attributes;
    }
}
