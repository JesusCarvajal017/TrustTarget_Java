package com.trustTarget.trustTarget.service;

import org.springframework.stereotype.Service;

import com.trustTarget.trustTarget.interfaces.ICompany;
import com.trustTarget.trustTarget.model.Company;

@Service
public class CompanyService extends GenericServices<Company, Integer> {
     public CompanyService(ICompany repository){
        super(repository);
    }
}
