package com.Internship.CarRental.service;
import com.Internship.CarRental.model.Car;
import com.Internship.CarRental.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    /***Constructor injection: Spring passes a ready UserRepository object*/
    public CarServiceImpl(CarRepository carRepository){
        this.carRepository = carRepository;
    }
    /**1.Create and Update Car*/
    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    /**2.Get every car*/
    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
    /**3.Get the cars of one user ID */
    @Override
    public List<Car> getCarsByUserId(Long userId) {
        return carRepository.findByOwnerId(userId);
    }


    /**4.Get one car by ID */
    @Override
    public Car getCarById(Long id) {
        Optional<Car> car = carRepository.findById(id);
        return car.orElseThrow(() ->new IllegalArgumentException("Car not found"));
    }


    /**4.Delete car by ID*/
    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

}
