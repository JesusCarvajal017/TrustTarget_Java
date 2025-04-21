package com.trustTarget.trustTarget.service;

import org.springframework.stereotype.Service;

import com.trustTarget.trustTarget.interfaces.Icity;
import com.trustTarget.trustTarget.model.City;

@Service
public class CityServices extends GenericServices<City, Integer> {
     public CityServices(Icity repository){
        super(repository);
    }
}
