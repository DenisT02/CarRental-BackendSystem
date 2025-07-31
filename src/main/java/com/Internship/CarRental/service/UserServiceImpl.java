package com.Internship.CarRental.service;

import com.Internship.CarRental.model.User;    //Adds the USER Entity
import com.Internship.CarRental.repository.UserRepository;  // Imports Repository layer
import org.springframework.stereotype.Service; //Marks this class as a SpringService

import java.util.List;  //Adds the lists
import java.util.Optional; //Handles the NullExeption

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository; //Reference to DB Layer

    /***Constructor injection: Spring passes a ready UserRepository object*/
    public UserServiceImpl (UserRepository userRepository){
        this.userRepository= userRepository;
    }

    /**Create or Update a user*/
    @Override
    public User saveUser(User user){
        return userRepository.save(user); //JPA does Insert or Update
    }
    /**List all the users*/
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();           // SELECT * FROM users
    }

    /**Get one user by ID*/
    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);  // SELECT … WHERE id =
        return user.orElse(null);                // Return null if not found
    }

    /**Delete a user*/
    public void deleteUser(Long id) {
        userRepository.deleteById(id);            // DELETE FROM users WHERE id = ?
    }



}
