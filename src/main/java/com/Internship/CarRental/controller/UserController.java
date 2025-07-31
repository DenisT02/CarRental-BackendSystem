package com.Internship.CarRental.controller;

import com.Internship.CarRental.model.User;
import com.Internship.CarRental.service.UserService;
import org.springframework.http.ResponseEntity;              //Library of http statuses 200,404,500
import org.springframework.web.bind.annotation.*;              // Library of Get,Post,dELETE MappING

import java.util.List;

@RestController // Marks Class as a Rest Controller
@RequestMapping("/users")  //base URL + Users

public class UserController {


    private final UserService userService;                   // Has dependency on service

    // Constructor injection → Spring passes UserService automatically
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*********************************************Create ************************************/
    @PostMapping                                              // POST /users
    public ResponseEntity<User> addUser(@RequestBody User user) {  // JSON  User
        User saved = userService.saveUser(user);              // Call service
        return ResponseEntity.ok(saved);                      // 200 OK + saved user
    }
    /****************************************Read All *************************************************/
    @GetMapping                                               // GET /users
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());  // 200 OK + list
    }

    /**************************************Read One **************************************************************/
    @GetMapping("/{id}")                                      // GET /users/1
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);              // May throw if not found
        return ResponseEntity.ok(user);                       // 200 OK + user
    }
    /****************************************DELETE *************************************************************/
    @DeleteMapping("/{id}")                                   // DELETE /users/1
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);                           // Remove user
        return ResponseEntity.noContent().build();            // 204 No Content
    }
}
