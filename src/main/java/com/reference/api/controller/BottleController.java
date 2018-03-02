package com.reference.api.controller;

import java.util.List;

import com.reference.api.models.Bottle;
import com.reference.api.models.BottleType;
import com.reference.api.repository.BottleRepository;
import com.reference.api.repository.BottleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@RestController
@RequestMapping("/bottle")
public class BottleController {
    @Autowired
    private BottleRepository bottleRepository;

    /**
     * Create a new bottle
     *
     * @param bottle
     * @return savedBottle
     */
    @RequestMapping(path = "/create",
            method = RequestMethod.POST,
            consumes =  MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create a bottle type")
    public Bottle add(@RequestBody Bottle bottle) {
        Bottle savedBottle =  bottleRepository.save(bottle);

        return savedBottle;
    }
    /***
     * Get a bottle by id
     */
    @RequestMapping(path="/bottle/{bottleID}", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Get a bottle by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Bottle.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Server Error")})
    public Bottle updateBottleType(@PathVariable("bottleID") Long id) {
        return bottleRepository.findOne(id);
    }
}
