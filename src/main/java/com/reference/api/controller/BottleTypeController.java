package com.reference.api.controller;

import java.util.List;

import com.reference.api.models.BottleType;
import com.reference.api.repository.BottleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@RestController
@RequestMapping("/bottletype")
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
        List<BottleType> bottles = (List<BottleType>) bottleTypeRepository.findByValide(true);
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
     * Get the list of the bottle types that aren't validated yet
     */
    @RequestMapping(path="/getBottleToValidate", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Get the list of the bottle types that aren't validated yet")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = BottleType.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Server Error")})
    public ResponseEntity getBottleToValidate() {
        List<BottleType> bottlesToValidate = bottleTypeRepository.findByValide(false);
        if(bottlesToValidate.size() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(bottlesToValidate);
        }
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
    @RequestMapping(path = "/delete/{id}",
            method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete a bottle type")
    public void delete(@PathVariable Long id) {
        bottleTypeRepository.delete(id);
    }


}
