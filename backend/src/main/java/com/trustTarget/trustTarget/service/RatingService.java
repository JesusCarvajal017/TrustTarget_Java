package com.trustTarget.trustTarget.service;

import org.springframework.stereotype.Service;

import com.trustTarget.trustTarget.interfaces.IRating;
import com.trustTarget.trustTarget.model.Rating;

@Service
public class RatingService extends GenericServices<Rating, Integer>  {
     public RatingService(IRating repository){
        super(repository);
    }
}
