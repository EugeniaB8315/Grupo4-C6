package com.grupo4.hotels.service;

//import com.grupo4.hotels.DTO.City.GetCityWithProductsDTO;

import com.grupo4.hotels.dto.City.CreateCityDTO;
import com.grupo4.hotels.dto.City.GetCityWithProductsDTO;
import com.grupo4.hotels.dto.City.UpdateCityDTO;
import com.grupo4.hotels.exception.ResourceNotFoundException;
import com.grupo4.hotels.model.City;
import com.grupo4.hotels.repository.CityRepository;
import com.grupo4.hotels.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    private CityRepository cityRepository;

    @Autowired
    private ProductRepository productRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Optional<City> find(Integer id) throws ResourceNotFoundException {
        if (cityRepository.findById(id).isPresent()) {
            return cityRepository.findById(id);
        } else {
            throw new ResourceNotFoundException("City not found");
        }
    }

    public List<City> findAll() {
        return cityRepository.findAll();
    }


    public GetCityWithProductsDTO findWithProducts(Integer id) throws ResourceNotFoundException {
        GetCityWithProductsDTO cityDTO = new GetCityWithProductsDTO();
        if (cityRepository.findById(id).isPresent()) {
            City city = cityRepository.findById(id).get();
            cityDTO.setId_city(city.getId());
            cityDTO.setTitle(city.getTitle());
            cityDTO.setProducts(city.getProducts());

        } else {
            throw new ResourceNotFoundException("You have to specify a valid City");
        }


        return cityDTO;
    }

    public City save(CreateCityDTO cityDTO) {
        City city = new City();
        CreateCityDTO newCityDTO = new CreateCityDTO();
        city.setTitle(cityDTO.getTitle());
        return cityRepository.save(city);
    }

    public void delete(Integer id) throws ResourceNotFoundException {
        if (cityRepository.findById(id).isPresent()) {
            cityRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("City not found");
        }
    }

    public City update(UpdateCityDTO cityDTO) throws ResourceNotFoundException {
        if (cityRepository.findById(cityDTO.getId()).isPresent()) {
            City city = cityRepository.findById(cityDTO.getId()).get();
            city.setTitle(cityDTO.getTitle());
            return cityRepository.save(city);
        } else {
            throw new ResourceNotFoundException("City not found");
        }
    }


    /*
    public City findWithProducts (Integer id) throws ResourceNotFoundException {

        Optional city= cityRepository.findById(id);
        City city1= new City();
        if (city.isPresent()){
             city1= (City) city.get();
            city1.setProducts(productRepository.findByCity(city1));
        }else{
            throw new ResourceNotFoundException("You have to specify a valid City");
        }

        return city1;


    }

     */


}
