package com.scorpion.easycar.controller;

import com.scorpion.easycar.datatransfer.RentRequestDTO;
import com.scorpion.easycar.service.CustomerBookingService;
import com.scorpion.easycar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("api/customer-booking")
public class CustomerBookingController {

    @Autowired
    private CustomerBookingService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getRequestId(RentRequestDTO dto){
        return new ResponseUtil(200, "OK", service.getRequestId());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil requestCarBooking(RentRequestDTO dto){
        service.requestCarBooking(dto);
        return new ResponseUtil(200, "OK", null);
    }
}

