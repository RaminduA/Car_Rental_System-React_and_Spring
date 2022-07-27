package com.scorpion.easycar.controller;

import com.scorpion.easycar.service.AdminBookingService;
import com.scorpion.easycar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("api/admin-booking")
public class AdminBookingController {

    @Autowired
    private AdminBookingService service;

    @GetMapping(path = "pending-requests", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllPendingRequests() {
        return new ResponseUtil(200, "OK", service.getAllPendingRequests());
    }

    @GetMapping(path = "driver-ids", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllDriverIds() {
        return new ResponseUtil(200, "OK", service.getAllDriverIds());
    }

    @GetMapping(path = "driver/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getDriver(@PathVariable String id) {
        return new ResponseUtil(200, "OK", service.getDriver(id));
    }

    @GetMapping(path = "weekly-schedule/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getDriverScheduleForTheWeek(@PathVariable String id) {
        return new ResponseUtil(200, "OK", service.getDriverScheduleForTheWeek(id));
    }

    @GetMapping(path = "monthly-schedule/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getDriverScheduleForTheMonth(@PathVariable String id) {
        return new ResponseUtil(200, "OK", service.getDriverScheduleForTheMonth(id));
    }

    @PutMapping(path = "deny/{id}/{message}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil denyRentRequest(@PathVariable String id, @PathVariable String message) {
        service.denyRentRequest(id,message);
        return new ResponseUtil(200, "OK", null);
    }

    @PutMapping(path = "accept/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil acceptRentRequest(@PathVariable String id) {
        service.acceptRentRequest(id);
        return new ResponseUtil(200, "OK", null);
    }

    @PutMapping(path = "accept/{id}/{driverId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil acceptRentRequestWithDifferentDriver(@PathVariable String id, @PathVariable String driverId) {
        try {
            service.acceptRentRequestWithDifferentDriver(id,driverId);
            return new ResponseUtil(200, "OK", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtil(500, "Error", null);
        }
    }
}
