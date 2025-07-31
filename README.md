              Project Documentation
Project Title: Car Rental Backend System
Purpose: This project implements the backend system for a car rental marketplace where users can:
-  Post cars for rent with detailed information
-  Book available cars listed by others
-  Automatically prevent overlapping bookings
-  Calculate total price based on booking dates and car price

Main Features
	Public Access (No Login Required)
-  View all cars
-  View detailed info about a car: brand, model, engine, price/day, transmission
-  Check availability for specific cars
	User’s Features
 - Create a user profile: first name, last name, phone, email
- Add a car with full specifications
 - Book a car by selecting start and end dates
-  System checks if the car is available for those dates
-  System calculates total price based on car price per day and number of days



Technologies Used
1.  Java 17+
2. Spring Boot Framework
3. Spring MVC Architecture (Model → Repository → Service → Controller)
4.Spring Data JPA (Hibernate)
5.  PostgreSQL database
6. Maven for dependency management
7.  Postman for API testing

Database Schema
	Users
| id | first_name | last_name | email  | phone |

	Cars
| id | owner_id(FK)| brand | model | transmission_type | engine | price_per_day |

	Bookings
| id |  car_id (FK) |booker_id(FK) | start_date | end_date | total_Price




API Endpoints
	User Endpoints

Method	Endpoint	Description
  POST	/users	Create a new user
    GET	/users	Get a list of all users
   GET	/users/{id}	Get details of one user

		

	Car Endpoints

Method	Endpoint	Description
POST	/cars	Add a new car (requires user ID in body)
GET	/cars	Get a list of all cars
GET	/cars/{id}	Get details of a specific car
GET	/cars/{id}/available-dates	Get available booking days for a car


	Booking Endpoints

Method	Endpoint	Description
POST	/bookings	Book a car (must include user ID and car ID)
GET	/bookings	Get a list of all bookings
GET	/bookings/{id}	Get details of a specific booking
GET	/bookings/user/{userId}	Get all bookings for a specific car
