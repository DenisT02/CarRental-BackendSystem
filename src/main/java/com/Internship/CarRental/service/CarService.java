package com.Internship.CarRental.service;
import com.Internship.CarRental.model.Car;
import org.apache.juli.logging.Log;

import java.util.List;

public interface CarService { //All service functionalities listed here
    Car saveCar(Car car);

    List<Car> getAllCars();

    List<Car> getCarsByUserId(Long userId); // gets the cars of 1 user

    Car getCarById(Long id);

    void deleteCar(Long id);
}
