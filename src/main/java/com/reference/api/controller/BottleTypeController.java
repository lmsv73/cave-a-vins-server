package com.reference.api.controller;

import java.util.List;

import com.reference.api.models.BottleType;
import com.reference.api.repository.BottleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@RestController
@RequestMapping("/api/bottletype")
public class BottleTypeController {
    @Autowired
    private BottleTypeRepository bottleTypeRepository;

    /**
     * Fetch a list of bottle type that are validated
     * @return a list of bottle type
     */
    @RequestMapping(path="/", method = RequestMethod.GET, produces = "application/json")

    @ApiOperation(value = "Fetch all type bottle")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = BottleType.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Server Error")})
    public ResponseEntity bottles() {
        List<BottleType> bottles = bottleTypeRepository.findByValide(true);
        if(bottles == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(bottles);
        }
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
        return bottleTypeRepository.save(bottleType);
    }

    /***
     *
     * Get all bottleTypes
     */
    @RequestMapping(path="/all", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Get the list of the bottle types that aren't validated yet")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = BottleType.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Server Error")})
    public ResponseEntity getBottleToValidate() {
        List<BottleType> bottlesTypes = bottleTypeRepository.findAll();
        if(bottlesTypes.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(bottlesTypes);
        }
    }

    /***
     * Update a bottle type
     */
    @RequestMapping(path="/", method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "Update a bottle type")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = BottleType.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Server Error")})
    public ResponseEntity updateBottleType(@RequestBody BottleType bottleType) {
        BottleType bottleToUpdate = bottleTypeRepository.save(bottleType);
        if(bottleToUpdate == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(bottleToUpdate);
        }
    }

    /**
     * Deletes bottle type identified with <code>id</code>
     * @param id
     */
    @RequestMapping(path = "/{id}",
            method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete a bottle type")
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            bottleTypeRepository.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (EmptyResultDataAccessException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


}
