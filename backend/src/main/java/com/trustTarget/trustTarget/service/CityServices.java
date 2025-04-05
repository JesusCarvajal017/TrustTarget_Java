package com.trustTarget.trustTarget.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustTarget.trustTarget.interfaces.Icity;
import com.trustTarget.trustTarget.model.City;

@Service
public class CityServices {
    @Autowired
    private Icity cityData;

    public List<City> getAllCities() {
        return cityData.findAll();
    }

    public Optional<City> getById(int id){
        return cityData.findById(id);
    }

    public void createCity(City city){
        cityData.save(city);
    }

    public void updateCity(City city){
        var cityExist = this.getById(city.getCity_id());
        if(cityExist.isPresent()){
            cityData.save(cityExist.get());
        }
        else{
            System.out.println("City not found with id: " + city.getCity_id());
        }
    }

    public void deleteCity(int id){
        var city = this.getById(id);
        if(city.isPresent()){
            cityData.delete(city.get());
        }else{
            System.out.println("City not found with id: " + id);
        }
    }
}
