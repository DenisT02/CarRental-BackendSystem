package com.Internship.CarRental.service;

import com.Internship.CarRental.model.User;
import java.util.List;
public interface UserService { //Service functionalities

    User saveUser (User user);  //Create/Update
    List<User>getAllUsers();    //Read all users
    User getUserById(Long Id);  //Read one specific user
    void deleteUser (Long id);  //Delete one specific user




}
