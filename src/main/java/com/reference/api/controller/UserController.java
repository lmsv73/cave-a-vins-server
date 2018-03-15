package com.reference.api.controller;

import java.util.List;

import com.reference.api.models.Bottle;
import com.reference.api.models.Compartment;
import com.reference.api.models.User;
import com.reference.api.repository.BottleRepository;
import com.reference.api.repository.CompartmentRepository;
import com.reference.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BottleRepository bottleRepository;
    @Autowired
    private CompartmentRepository compartmentRepository;

    /**
     * Create a new user
     *
     * @param user
     * @return savedUser
     */
    @RequestMapping(path = "/create",
            method = RequestMethod.POST,
            consumes =  MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create a user")
    public User add(@RequestBody User user) {
        return userRepository.save(user);
    }

    /***
     * User login
     */
    @RequestMapping(path = "/login" ,
            method = RequestMethod.GET )
    @ApiOperation(value = "Login a user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = User.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Server Error")})
    public ResponseEntity<User> login(@RequestParam("username") String username, @RequestParam("password") String password){
        List<User> savedUser = userRepository.findByUsernameAndPassword(username,password);
        if(savedUser.size()==0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(savedUser.get(0));
        }
    }

    /**
     * Fetch list of user's bottle
     * @return a list of bottle
     */
    @RequestMapping(path="/bottles", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Fetch all bottle of the user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Server Error")})
    public ResponseEntity bottles(@RequestParam String username) {
        List<Bottle> bottles = bottleRepository.findByOwner(userRepository.findOneByUsername(username));
        if(bottles.size()==0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(bottles);
        }
    }

    /**
     * Fetch user's compartment
     * @return a list of bottle
     */
    @RequestMapping(path="/compartments", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Fetch all compartments of the user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Server Error")})
    public ResponseEntity compartments(@RequestParam String username) {
        User u = userRepository.findOneByUsername(username);
        if(u == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(u);
        }
    }
}
