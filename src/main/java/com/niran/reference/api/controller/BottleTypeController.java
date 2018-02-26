package com.niran.reference.api.controller;

import java.util.List;

import com.niran.reference.api.domain.BottleType;
import com.niran.reference.api.domain.BottleTypeRepository;
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
@RequestMapping("/bottletype")
public class BottleTypeController {
    @Autowired
    private BottleTypeRepository bottleTypeRepository;

    /**
     * Fetch a list of bottle type
     * @return a list of bottle type
     */
    @RequestMapping(path="/", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Fetch all type bottle")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = BottleType.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Server Error")})
    public List<BottleType> bottles() {
        List<BottleType> bottles = (List<BottleType>) bottleTypeRepository.findAll();

        return bottles;
    }

    /**
     * Create a new bottle type
     *
     * @param bottleType
     * @return savedBottleType
     */
    @RequestMapping(path = "/",
            method = RequestMethod.POST,
            consumes =  MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create a bottle type")
    public BottleType add(@RequestBody BottleType bottleType) {
        BottleType savedBottleType =  bottleTypeRepository.save(bottleType);

        return savedBottleType;
    }

    /***
     *
     * Get the list of the bottle types that aren't validated yet
     */
    @RequestMapping(path="/getBottleToValidate", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Get the list of the bottle types that aren't validated yet")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = BottleType.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Server Error")})
    public List<BottleType> getBottleToValidate() {
        List<BottleType> bottles = bottleTypeRepository.findByValide(false);
        return bottles;
    }

    /***
     * Update a bottle type
     */
    @RequestMapping(path="/update", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "Update a bottle type")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = BottleType.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Server Error")})
    public BottleType updateBottleType(@RequestBody BottleType bottleType) {
        BottleType bottletype = bottleTypeRepository.save(bottleType);
        return bottletype;
    }

    /**
     * Deletes bottle type identified with <code>id</code>
     * @param id
     */
    @RequestMapping(path = "/delete/{id}",
            method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete a bottle type")
    public void delete(@PathVariable Long id) {
        bottleTypeRepository.delete(id);
    }


}
