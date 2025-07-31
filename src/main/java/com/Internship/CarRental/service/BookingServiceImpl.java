package com.Internship.CarRental.service;

import com.Internship.CarRental.model.Booking; // Gets data from entities
import com.Internship.CarRental.repository.BookingRepository; // Connects to DB through Repo
import com.Internship.CarRental.model.Car;
import com.Internship.CarRental.repository.CarRepository;
import org.springframework.stereotype.Service; // Tells that this is a class of a business logic
import org.springframework.web.server.ResponseStatusException;  // Response statuses so it does not come err500
import org.springframework.http.HttpStatus;

import java.time.temporal.ChronoUnit; //Calculates how many days are between 2 days
import java.util.List;
import java.util.Optional;




@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final CarRepository carRepository;

    // constructor injection for BOTH repositories
    public BookingServiceImpl(BookingRepository bookingRepository,
                              CarRepository carRepository) {
        this.bookingRepository = bookingRepository;
        this.carRepository    = carRepository;
    }

    /**
     * Save a booking (with overlap check and price calculation)
     */
    @Override
    public Booking saveBooking(Booking booking) {
        //0. Start date should olways be before end date
        if (booking.getStartDate().isAfter(booking.getEndDate())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Start date must be before or equal to end date"
            );
        }

        // 1. overlap check
        boolean conflict =
                bookingRepository.existsByCarIdAndEndDateAfterAndStartDateBefore(
                        booking.getCar().getId(),
                        booking.getStartDate(),
                        booking.getEndDate()
                );
        if (conflict) {
            throw new IllegalStateException("Car is already booked for these dates.");
        }

        // 2. fetch full car (so we have pricePerDay)
        Car fullCar = carRepository.findById(booking.getCar().getId())
                .orElseThrow(() -> new IllegalArgumentException("Car not found"));
        booking.setCar(fullCar);

        // 3. calculate total price
        long days  = ChronoUnit.DAYS.between(booking.getStartDate(), booking.getEndDate()) + 1;// dita fundit
        double total = days * fullCar.getPricePerDay();
        total = Math.round(total * 100.0) / 100.0; // Number * 100 , then round to the nearest , then /100
        booking.setTotalPrice(total);

        // 4. save & return
        return bookingRepository.save(booking);
    }

    /**1.Get all bookings */
    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    /**2.Get a specific booking  */
    @Override
    public Booking getBookingById(Long id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        return booking.orElseThrow(() -> new IllegalArgumentException("Booking not found"));
    }
    /**3.Get bookings by car ID  */
    @Override
    public List<Booking> getBookingsByCarId(Long carId) {
        return bookingRepository.findByCarId(carId);
    }
    /**4.Get bookings by User ID  */

    @Override
    public List<Booking> getBookingsByUserId(Long userId) {
        return bookingRepository.findByBookerId(userId);
    }

    /**5. Delete a booking by Id  */
    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }





}

