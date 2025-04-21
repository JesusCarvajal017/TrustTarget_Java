package com.trustTarget.trustTarget.service;

import org.springframework.stereotype.Service;

import com.trustTarget.trustTarget.interfaces.ICounty;
import com.trustTarget.trustTarget.model.Country;

@Service
public class CountryService extends GenericServices<Country, Integer> {
     public CountryService(ICounty repository){
        super(repository);
    }
}
