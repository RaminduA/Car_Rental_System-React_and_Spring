package com.scorpion.easycar.controller;


import com.scorpion.easycar.datatransfer.CarDTO;
import com.scorpion.easycar.service.AdminCarsService;
import com.scorpion.easycar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@RestController
@CrossOrigin
@RequestMapping("api/customer-notifications")
public class CustomerNotificationsController {

    @Autowired
    private CustomerNotificationsService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllUnseenResponses() {
        return new ResponseUtil(200, "OK", service.getAllUnseenResponses());
    }

    @PutMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil makeResponseSeen(@PathVariable String id) {
        service.makeResponseSeen(id);
        return new ResponseUtil(200, "Updated", null);
    }
}
