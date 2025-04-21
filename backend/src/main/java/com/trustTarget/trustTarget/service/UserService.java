package com.trustTarget.trustTarget.service;

import org.springframework.stereotype.Service;

// import com.trustTarget.trustTarget.dtos.StatusDto;
// import com.trustTarget.trustTarget.dtos.UserDto;
import com.trustTarget.trustTarget.interfaces.IUser;
// import com.trustTarget.trustTarget.interfaces.IUserDto;
import com.trustTarget.trustTarget.model.User;

@Service
public class UserService extends GenericServices<User, Long> {

    private final IUser userRepository;

    public UserService(IUser repository){
        super(repository);
        this.userRepository = repository;
    }

    public User queryUserName(String user_names){
        User user = userRepository.findByUserNames(user_names);
        return user;
    }

    // public StatusDto createEntity(UserDto Entity){
    //     try {
    //         generic.save(Entity);
    //         return new StatusDto(true, "successful registration");
    //     } catch (Exception e) {
    //         System.out.println("Error creating Entity: " + e.getMessage());
    //         return new StatusDto(false, "registration denied", e.getMessage());
    //     }     
    // }

    // public StatusDto updateEntity(T Entity){
    //     var exist = this.getById(Entity.getId());
    //     if(exist.isPresent()){
    //         generic.save(Entity);
    //         return new StatusDto(true, "successful update");
    //     }
    //     else{
    //         System.out.println("Entity not found with id: " + Entity.getId());
    //         return new StatusDto(false, "update denied");
    //     }
    // }
}
