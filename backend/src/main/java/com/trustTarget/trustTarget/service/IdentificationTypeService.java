package com.trustTarget.trustTarget.service;

import org.springframework.stereotype.Service;

import com.trustTarget.trustTarget.interfaces.IidentificationType;
import com.trustTarget.trustTarget.model.IdentificationType;

@Service
public class IdentificationTypeService extends GenericServices<IdentificationType, Integer>{

    public IdentificationTypeService(IidentificationType repository){
        super(repository);
    }
    
}
