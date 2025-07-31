package com.Internship.CarRental.controller;

import com.Internship.CarRental.model.Car;
import com.Internship.CarRental.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/cars")                                      // Base URL → /cars
public class CarController {

    private final CarService carService;                      // Injected service

    public CarController(CarService carService) {
        this.carService = carService;
    }

    /**************************************CREATE***************************************************/
    @PostMapping                                              // POST /cars
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        Car saved = carService.saveCar(car);                  // Save via service
        return ResponseEntity.ok(saved);                      // Return saved car
    }

    /*****************************************READ ALL***************************************************/
    @GetMapping                                               // GET /cars
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());    // Return list
    }

    /**********************************READ ONE ***************************************************************/
    @GetMapping("/{id}")                                      // GET /cars/1
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        return ResponseEntity.ok(carService.getCarById(id));  // Return single car
    }

    /*********************************Read by User********************************************************************/
    @GetMapping("/user/{userId}")                             // GET /cars/user/5
    public ResponseEntity<List<Car>> getCarsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(carService.getCarsByUserId(userId));
    }

    /** ── AVAILABLE-DATES (calculated on the fly, no extra table) */
    @GetMapping("/{id}/available-dates")                      // GET /cars/1/available-dates
    public ResponseEntity<List<LocalDate>> getAvailableDates(
            @PathVariable Long id,
            @RequestParam(defaultValue = "30") int daysAhead) { // Optional query param

        // 1. Build full date window (today  +daysAhead)
        LocalDate start = LocalDate.now();
        LocalDate end = start.plusDays(daysAhead);

        // 2. Get all bookings for this car in that window
        List<LocalDate> busy = new ArrayList<>();            // We’ll fill this list later
        // You would call bookingService here; omitted for brevity

        // 3. Build free list
        List<LocalDate> free = new ArrayList<>();
        LocalDate cursor = start;
        Set<LocalDate> busySet = new HashSet<>(busy);        // Faster look-ups
        while (!cursor.isAfter(end)) {
            if (!busySet.contains(cursor)) free.add(cursor); // Day is free
            cursor = cursor.plusDays(1);
        }

        return ResponseEntity.ok(free);                      // Return free dates
    }

    /************************************DELETE*************************************************/
    @DeleteMapping("/{id}")                                   // DELETE /cars/1
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }
}