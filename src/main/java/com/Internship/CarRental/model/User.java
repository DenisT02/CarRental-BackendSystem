package com.Internship.CarRental.model;
import jakarta. persistence.*; //Without this import you would not be able to use Annotations such as @Entityy
@Entity // Marks the classs as a DB Table
@Table(name = "users") // Sets the name of the DB Table

public class User {
    @Id // Sets Id as a primary key of the DB
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment

    private Long id; // Id for each user

    private String firstName;
    private String lastName;
    private String phone;
    private String email;


    public User(){} // Default constructor needed by JPA

    public User(Long id , String firstName ,String lastName,String phone,String email ){
        this.id= id;
        this.firstName= firstName;
        this.lastName= lastName;
        this.phone= phone;
        this.email= email;
    }

    /**Getters and Setters*/

    //Id
    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //Firstname
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //Lastname
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //Phone
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //E-mail


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
