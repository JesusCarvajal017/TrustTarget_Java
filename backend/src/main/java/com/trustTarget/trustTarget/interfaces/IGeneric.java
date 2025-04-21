package com.trustTarget.trustTarget.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IGeneric<T, ID> extends JpaRepository<T, ID> 
{
    
}

