package com.scorpion.easycar.controller;

import com.scorpion.easycar.datatransfer.RentResponseDTO;
import com.scorpion.easycar.service.AdminBookingService;
import com.scorpion.easycar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("api/admin-bookings")
public class AdminBookingsController {

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

    @GetMapping(path = "response-id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getResponseId() {
        return new ResponseUtil(200, "OK", service.getResponseId());
    }

    @GetMapping(path = "rental-id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getRentalId() {
        return new ResponseUtil(200, "OK", service.getRentalId());
    }

    @GetMapping(path = "weekly-schedule/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getDriverScheduleForTheWeek(@PathVariable String id) {
        return new ResponseUtil(200, "OK", service.getDriverScheduleForTheWeek(id));
    }

    @GetMapping(path = "monthly-schedule/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getDriverScheduleForTheMonth(@PathVariable String id) {
        return new ResponseUtil(200, "OK", service.getDriverScheduleForTheMonth(id));
    }

    @PutMapping(path = "deny", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil denyRentRequest(@RequestBody RentResponseDTO dto) {
        service.denyRentRequest(dto);
        return new ResponseUtil(200, "OK", null);
    }

    @PutMapping(path = "accept/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil acceptRentRequest(@RequestBody RentResponseDTO dto) {
        service.acceptRentRequest(dto);
        return new ResponseUtil(200, "OK", null);
    }

    @PutMapping(path = "accept/{driverId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil acceptRentRequestWithDifferentDriver(@RequestBody RentResponseDTO dto, @PathVariable String driverId) {
        try {
            service.acceptRentRequestWithDifferentDriver(dto,driverId);
            return new ResponseUtil(200, "OK", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtil(500, "Error", null);
        }
    }
}
