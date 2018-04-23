package com.reference.api.controller;

import io.swagger.annotations.ApiOperation;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/regions")
public class RegionController {


    /***
     * Get the french natural regions
     * https://fr.wikipedia.org/wiki/Liste_des_r%C3%A9gions_naturelles_de_France
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get the french natural regions")
    public ResponseEntity<List<String>> getRegions() throws IOException {


        File file = new File("region_naturel.csv");

        BufferedReader in = new BufferedReader(new FileReader(file));
        List<String> regions = in .lines() .distinct().collect(Collectors.toList());

        return ResponseEntity
                .ok()
                .body(regions);
    }

}
