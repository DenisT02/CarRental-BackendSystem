package com.Internship.CarRental.model;

import jakarta. persistence.*; //Without this import you would not be able to use Annotations such as @Entityy
@Entity // Marks the classs as a DB Table
@Table(name = "cars") // Sets the name of the DB Table

public class Car {
    @Id // This is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-Increment the ID

    private Long id; // Unique ID for each car


    @ManyToOne                                  // many cars can have the same user
    @JoinColumn(name = "owner_id")               // FK column in cars table
    private User owner;                          // the owner

    private String brand;
    private String model;
    private String engine;
    private String transmissionType;
    private double pricePerDay;


    // This empty constructor is needed by JPA. // Without it : "No default constructor found for entity"
    public Car(){}

    //Constructor with arguments
    public Car(Long id,User owner, String brand,String model,String engine,String transmissionType,double pricePerDay){
        this.id = id;
        this.owner= owner;
        this.model = model;
        this.brand = brand;
        this.engine = engine;
        this.transmissionType = transmissionType;
        this.pricePerDay=pricePerDay;
    }

    /**Getters and Setters */

    //Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //User
    public User getOwner() {
        return owner;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }

    //Brand
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    //Model
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    //Engine
    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine=engine;
    }

    //TransmissionType
    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType=transmissionType;
    }

    //Price
    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
}
