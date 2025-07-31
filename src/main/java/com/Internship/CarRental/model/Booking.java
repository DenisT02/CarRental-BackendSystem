package com.Internship.CarRental.model;
import jakarta.persistence.*; //Without this import you would not be able to use Annotations such as @Entityy
import java.time.LocalDate;

@Entity                                               //Marks the classs as a DB Table
@Table(name = "bookings")                            // Sets the name of the DB Table


public class Booking {
    @Id // Sets Id as a primary key of the DB
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment

    private Long id; // A unique booking Id

    /**Relationships*/
    @ManyToOne //Many bookings can have the same user
    @JoinColumn(name = "booker_id") //Foreign key in the table Booking
    private User booker; // User = class / user = actual booker , who booked the car

    @ManyToOne                          // Many bookings can have one car
    @JoinColumn(name = "car_id")        // Foreign Key in the table booking
    private Car car;                    // Which car is booked/ Car = Class , car = actual car


    //Booking details
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalPrice;



    //Constructor

    public Booking(){}       //Empty constructor

    public Booking(Long id , User user, Car car, LocalDate startDate, LocalDate endDate, double totalPrice ){
        this.id= id;
        this.booker = user;
        this.car = car;
        this.startDate= startDate;
        this.endDate=endDate;
        this.totalPrice=totalPrice;
    }

    /**Getters and setters*/
    //Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //User
    public User getBooker() {
        return booker;
    }

    public void setBooker(User user) {
        this.booker = user;
    }

    //Car
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    //StartDate
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    //EndDate
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    //TotalPrice
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
