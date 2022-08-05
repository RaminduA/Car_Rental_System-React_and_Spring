package com.scorpion.easycar.controller;

import com.scorpion.easycar.datatransfer.DriverDTO;
import com.scorpion.easycar.service.AdminDriversService;
import com.scorpion.easycar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("api/admin-drivers")
public class AdminDriversController {

    @Autowired
    private AdminDriversService service;

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getDriver(@PathVariable String id){
        return new ResponseUtil(200, "OK", service.getDriver(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllDrivers(){
        return new ResponseUtil(200, "OK", service.getAllDrivers());
    }

    @GetMapping(path = "id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getDriverId(){
        return new ResponseUtil(200, "OK", service.getDriverId());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveDriver(DriverDTO dto){
        service.saveDriver(dto);
        return new ResponseUtil(200, "Saved", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateDriver(@RequestBody DriverDTO dto){
        service.updateDriver(dto);
        return new ResponseUtil(200, "Updated", null);
    }

    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteDriver(@RequestParam String id){
        service.deleteDriver(id);
        return new ResponseUtil(200, "Deleted", null);
    }

    @GetMapping(path = "get-by-account/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getDriverByAccountId(@PathVariable String accountId){
        return new ResponseUtil(200, "OK", service.getDriverByAccountId(accountId));
    }

    @PutMapping(path = "set-status/{status}/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateStatus(@PathVariable String status, @PathVariable String id){
        service.updateStatus(status,id);
        return new ResponseUtil(200,"Updated",null);
    }

    @GetMapping(path = "all-available",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllAvailable(){
        return new ResponseUtil(200,"OK",service.getAllAvailable());
    }

    @GetMapping(path = "count/{status}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getCountByStatus(@PathVariable String status){
        return new ResponseUtil(200,"OK",service.getCountByStatus(status));
    }
}