package com.scorpion.easycar.controller;


import com.scorpion.easycar.datatransfer.CustomerDTO;
import com.scorpion.easycar.service.AdminCustomersService;
import com.scorpion.easycar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("api/admin-customers")
public class AdminCustomersController {

    @Autowired
    private AdminCustomersService service;

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getCustomer(@PathVariable String id) {
        return new ResponseUtil(200, "OK", service.getCustomer(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCustomers() {
        return new ResponseUtil(200, "OK", service.getAllCustomers());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCustomer(CustomerDTO dto) {
        service.saveCustomer(dto);
        return new ResponseUtil(200, "Saved", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO dto) {
        service.updateCustomer(dto);
        return new ResponseUtil(200, "Updated", null);
    }

    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCustomer(@RequestParam String id) {
        service.deleteCustomer(id);
        return new ResponseUtil(200, "Deleted", null);
    }
}
