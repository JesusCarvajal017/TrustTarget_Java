package com.trustTarget.trustTarget.service;

import org.springframework.stereotype.Service;

import com.trustTarget.trustTarget.interfaces.IProfession;
import com.trustTarget.trustTarget.model.Profession;

@Service
public class ProfessionService extends GenericServices<Profession, Integer>  {

     public ProfessionService(IProfession repository){
        super(repository);
    }
}
