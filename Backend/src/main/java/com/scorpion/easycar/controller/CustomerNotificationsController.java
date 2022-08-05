package com.scorpion.easycar.controller;

import com.scorpion.easycar.service.CustomerNotificationsService;
import com.scorpion.easycar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("api/customer-notifications")
public class CustomerNotificationsController {

    @Autowired
    private CustomerNotificationsService service;

    @GetMapping(path = "{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllUnseenResponses(@PathVariable String customerId) {
        return new ResponseUtil(200, "OK", service.getAllUnseenResponses(customerId));
    }

    @PutMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil makeResponseSeen(@PathVariable String id) {
        service.makeResponseSeen(id);
        return new ResponseUtil(200, "Updated", null);
    }
}
