package com.scorpion.easycar.controller;

import com.scorpion.easycar.service.CommonCarsService;
import com.scorpion.easycar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("api/common-cars")
public class CommonCarsController {

    @Autowired
    private CommonCarsService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCars() {
        return new ResponseUtil(200, "OK", service.getAllCars());
    }

    @GetMapping(path = "{criteria}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCarsSortedByCriteria(@PathVariable String criteria) {
        switch(criteria){
            case "passenger-count" :
                return new ResponseUtil(200, "OK", service.getAllCarsSortedByPassengerCount());
            case "transmission-type" :
                return new ResponseUtil(200, "OK", service.getAllCarsSortedByTransmissionType());
            case "brand" :
                return new ResponseUtil(200, "OK", service.getAllCarsSortedByBrand());
            case "type" :
                return new ResponseUtil(200, "OK", service.getAllCarsSortedByType());
            case "price" :
                return new ResponseUtil(200, "OK", service.getAllCarsSortedByPrice());
            case "fuel-type" :
                return new ResponseUtil(200, "OK", service.getAllCarsSortedByFuelType());
            default :
                return new ResponseUtil(200, "OK", service.getAllCars());
        }
    }

}

