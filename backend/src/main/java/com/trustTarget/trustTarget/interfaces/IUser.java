package com.trustTarget.trustTarget.interfaces;

import org.springframework.stereotype.Repository;

import com.trustTarget.trustTarget.model.User;

@Repository
public interface IUser extends IGeneric<User, Long>{

    // Para buscar un solo resultado exacto
    User findByUserNames(String user_names);
}
