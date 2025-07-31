package com.Internship.CarRental.repository;

import com.Internship.CarRental.model.Booking; //Imports the user Entity so we can manage the data
import org.springframework.data.jpa.repository.JpaRepository; //Import JPA Repo ,to use the SpringJpa features
import java.util.List;
import java.time.LocalDate;


// This interface allows us to perform CRUD operations on the table
public interface BookingRepository extends JpaRepository<Booking,  Long> {

    //Custom method to get all the booking of one specific car
    List<Booking> findByCarId(Long carId);


    //Custom method to get all the bookings of one specific user
    List<Booking> findByBookerId(Long bookerId);


    //Custom method to check is the car is booked in the given dates
    //It is a system method and it should be written in a given format
    boolean existsByCarIdAndEndDateAfterAndStartDateBefore(
            Long carId, LocalDate startDate, LocalDate endDate);
}


