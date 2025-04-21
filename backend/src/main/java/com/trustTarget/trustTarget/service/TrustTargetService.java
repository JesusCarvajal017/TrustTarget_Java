package com.trustTarget.trustTarget.service;

import org.springframework.stereotype.Service;

import com.trustTarget.trustTarget.interfaces.ITrustTarget;
import com.trustTarget.trustTarget.model.TrustTarget;

@Service
public class TrustTargetService extends GenericServices<TrustTarget, Integer>  {
     public TrustTargetService(ITrustTarget repository){
        super(repository);
    }
}
