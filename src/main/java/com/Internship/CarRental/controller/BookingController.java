package com.Internship.CarRental.controller;

import com.Internship.CarRental.model.Booking;
import com.Internship.CarRental.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/bookings")                                  // Base URL → /bookings
public class BookingController {

    private final BookingService bookingService;              // Injected service

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    /****************************************CREATE***************************************/
    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody Booking booking) {
        try {
            Booking saved = bookingService.saveBooking(booking);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT); // 409
        }
    }
    /******************************* READ ALL*****************************************************/
    @GetMapping                                               // GET /bookings
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    /*******************************READ ONE ****************************************************/
    @GetMapping("/{id}")                                      // GET /bookings/1
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.getBookingById(id));
    }

    /*************************READ BY CAR ID (for availability & admin use) ************************/
    @GetMapping("/car/{carId}")                               // GET /bookings/car/3
    public ResponseEntity<List<Booking>> getBookingsByCar(@PathVariable Long carId) {
        return ResponseEntity.ok(bookingService.getBookingsByCarId(carId));
    }

    /**************** READ BY USER ID (user's own bookings)***********************************************/
    @GetMapping("/user/{userId}")                             // GET /bookings/user/2
    public ResponseEntity<List<Booking>> getBookingsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(bookingService.getBookingsByUserId(userId));
    }

    /***************************************DELETE ******************************************************/
    @DeleteMapping("/{id}")                                   // DELETE /bookings/1
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}
