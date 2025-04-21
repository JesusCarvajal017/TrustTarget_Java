package com.trustTarget.trustTarget.service;

import java.util.List;
import java.util.Optional;

import com.trustTarget.trustTarget.dtos.StatusDto;
import com.trustTarget.trustTarget.interfaces.IGeneric;
import com.trustTarget.trustTarget.interfaces.Identificable;


public abstract class GenericServices<T extends Identificable<ID> , ID> {
    
    protected final IGeneric<T, ID> generic;

    public GenericServices(IGeneric<T, ID> generic){
        this.generic = generic;
    }

    public List<T> getAll() {
        return generic.findAll();
    }

    public Optional<T> getById(ID id){
        var entity = generic.findById(id);

        return entity;
    }

    public StatusDto createEntity(T Entity){
        try {
            generic.save(Entity);
            return new StatusDto(true, "successful registration");
        } catch (Exception e) {
            System.out.println("Error creating Entity: " + e.getMessage());
            return new StatusDto(false, "registration denied", e.getMessage());
        }     
    }

    public StatusDto updateEntity(T Entity){
        var exist = this.getById(Entity.getId());
        if(exist.isPresent()){
            generic.save(Entity);
            return new StatusDto(true, "successful update");
        }
        else{
            System.out.println("Entity not found with id: " + Entity.getId());
            return new StatusDto(false, "update denied");
        }
    }

    public StatusDto deleteEntity(ID id){
        var entity = this.getById(id);
        if(entity.isPresent()){
            generic.delete(entity.get());
            return new StatusDto(true, "successful delete");
        }else{
            System.out.println("Entity not found with id: " + id);
            return new StatusDto(false, "delete  denied");
        }
    }
    
    // public abstract StatusDto updateEntity(T Entity); // solo implementacion, por el Id
}
