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
    @RequestMapping(path="/all", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Fetch all type bottle")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = BottleType.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Server Error")})
    public List<BottleType> bottles() {
        List<BottleType> bottles = (List<BottleType>) bottleTypeRepository.findAll();

        return bottles;
    }
}
