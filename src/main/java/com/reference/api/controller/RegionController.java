package com.reference.api.controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/regions")
public class RegionController {


    /***
     * Get regions list
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getRegions() throws IOException {


        File file = new File("region_naturel.csv");

        BufferedReader in = new BufferedReader(new FileReader(file));
        List<String> regions = in .lines() .distinct().collect(Collectors.toList());

        return ResponseEntity
                .ok()
                .body(regions);
    }

}
