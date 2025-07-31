package com.Internship.CarRental.service;
import com.Internship.CarRental.model.Booking;
import java.util.List;

public interface BookingService {

    Booking saveBooking(Booking booking); // Create a booking

    List<Booking> getAllBookings(); // Get all bookings

    Booking getBookingById(Long id); // Get one booking

    List<Booking> getBookingsByUserId(Long userId);  // Get all bookings made by the same  user

    List<Booking> getBookingsByCarId(Long carId);  //  Get all bookings for a specific car

    void deleteBooking(Long id); // Delete a booking
}
