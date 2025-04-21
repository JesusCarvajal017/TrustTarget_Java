package com.trustTarget.trustTarget.service;

import org.springframework.stereotype.Service;

import com.trustTarget.trustTarget.interfaces.IRegion;
import com.trustTarget.trustTarget.model.Region;

@Service
public class RegionService extends GenericServices<Region, Integer> {
     public RegionService(IRegion repository){
        super(repository);
    }
}
