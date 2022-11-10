package com.grupo4.hotels.controller;

//import com.grupo4.hotels.DTO.City.GetCityWithProductsDTO;

import com.grupo4.hotels.dto.City.CreateCityDTO;
import com.grupo4.hotels.dto.City.GetCityWithProductsDTO;
import com.grupo4.hotels.dto.City.UpdateCityDTO;
import com.grupo4.hotels.exception.ResourceNotFoundException;
import com.grupo4.hotels.model.City;
import com.grupo4.hotels.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public ResponseEntity<List<City>> findAll() {
        return ResponseEntity.ok(cityService.findAll());
    }

    //    @GetMapping("/{id}")
//    public ResponseEntity<Optional<City>> findById(@PathVariable Integer id) throws ResourceNotFoundException {
//        return ResponseEntity.ok(cityService.find(id));
//
//    }
    @GetMapping("/{id}")
    public ResponseEntity<GetCityWithProductsDTO> findByIdWithOutProducts(@PathVariable Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(cityService.findWithProducts(id));
    }

    @PostMapping
    public ResponseEntity<City> create(@RequestBody CreateCityDTO createCityDTO) {
        return ResponseEntity.ok(cityService.save(createCityDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) throws ResourceNotFoundException {
        cityService.delete(id);
        return ResponseEntity.ok("City with id " + id + " was deleted");
    }

    @PutMapping
    public ResponseEntity<City> update(@RequestBody UpdateCityDTO updateCityDTO) throws ResourceNotFoundException {
        return ResponseEntity.ok(cityService.update(updateCityDTO));
    }
}
