package com.trustTarget.trustTarget.service;

import org.springframework.stereotype.Service;

import com.trustTarget.trustTarget.interfaces.ITrustNivels;
import com.trustTarget.trustTarget.model.TrustNivels;

@Service
public class TrustNivelService extends GenericServices<TrustNivels, Integer> {
     public TrustNivelService(ITrustNivels repository){
        super(repository);
    }
}
