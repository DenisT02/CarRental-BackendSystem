package com.Internship.CarRental.repository;

import com.Internship.CarRental.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,  Long> {


    /*This is a custom filter not supported by JPA ,
     that is why we have to add it manually
      It will auto generate the query :"SELECT * FROM cars WHERE user_id = ?" */
    List<Car>findByOwnerId(Long ownerId);
}