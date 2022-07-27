package com.scorpion.easycar.controller;

import com.scorpion.easycar.service.DriverScheduleService;
import com.scorpion.easycar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("api/driver-schedule")
public class DriverScheduleController {

    @Autowired
    private DriverScheduleService service;

    @GetMapping(path = "weekly-schedule/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getScheduleForTheWeek(@PathVariable String id) {
        return new ResponseUtil(200, "OK", service.getScheduleForTheWeek(id));
    }

    @GetMapping(path = "monthly-schedule/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getScheduleForTheMonth(@PathVariable String id) {
        return new ResponseUtil(200, "OK", service.getScheduleForTheMonth(id));
    }
}

