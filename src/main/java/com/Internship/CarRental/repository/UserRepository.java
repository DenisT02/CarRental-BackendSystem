package com.Internship.CarRental.repository;

import com.Internship.CarRental.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,  Long> { //Class: User , PK: Long datatype
}
/**Jpa Repository makes CRUD possible:
 * findAll();         // Get all users
 *findById(1L);      // Find user with ID 1
 * save(car);         // Save  a car
 * delete(car);       // Delete a car */