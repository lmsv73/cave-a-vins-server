package com.reference.api.controller;

import java.util.Arrays;
import java.util.List;

import com.reference.api.models.Bottle;
import com.reference.api.models.Compartment;
import com.reference.api.models.User;
import com.reference.api.models.Role;
import com.reference.api.repository.BottleRepository;
import com.reference.api.repository.CompartmentRepository;
import com.reference.api.repository.RoleRepository;
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
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BottleRepository bottleRepository;
    @Autowired
    private CompartmentRepository compartmentRepository;
    @Autowired
    private RoleRepository roleRepository;

    /**
     * Create a new user
     *
     * @param username
     * @param password
     * @return savedUser
     */
    @RequestMapping(path = "/",
            method = RequestMethod.POST,
            consumes =  MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create a new user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = User.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Server Error")})
    public ResponseEntity<User> add(@RequestParam("username") String username, @RequestParam("password") String password) {
        User usr = userRepository.findOneByUsername(username);

        if(usr == null){
            Role rl = roleRepository.findByName("USER_ROLE");
            User u = new User(username, password);
            u.setRoles(Arrays.asList(rl));
            userRepository.save(u);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /**
     * Fetch user's bottles
     * @return a list of bottle
     */
    @RequestMapping(path="/bottles", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Fetch user's bottles")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Server Error")})
    public ResponseEntity bottles(@RequestParam String username) {
        List<Bottle> bottles = bottleRepository.findByOwner(userRepository.findOneByUsername(username));
        return ResponseEntity.status(HttpStatus.OK).body(bottles);
    }

    /**
     * Fetch user's compartments
     * @return a list of bottle
     */
    @RequestMapping(path="/compartments", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Fetch user's compartments")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Server Error")})
    public ResponseEntity compartments(@RequestParam String username) {
        User u = userRepository.findOneByUsername(username);
        if(u == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            List<Compartment> compartments = compartmentRepository.findByOwner(u);
            return ResponseEntity.status(HttpStatus.OK).body(compartments);
        }
    }


    /**
     * Fetch user's credendials
     * @return a user
     */
    @RequestMapping(path="/credentials", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Fetch user's credendials")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Server Error")})
    public ResponseEntity credentials(@RequestParam String username) {
        User u = userRepository.findOneByUsername(username);
        if(u == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(u);
        }
    }
}
