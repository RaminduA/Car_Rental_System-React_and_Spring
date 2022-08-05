package com.scorpion.easycar.controller;

import com.scorpion.easycar.service.LoginRegisterService;
import com.scorpion.easycar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("api/login-register")
public class LoginRegisterController {

    @Autowired
    private LoginRegisterService service;

    @GetMapping(params = {"username","password"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil loginUser(String username, String password) {
        return new ResponseUtil(200, "Login Successful", service.loginUser(username,password));
    }

    @GetMapping(path = "get-customer-id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getCustomerId() {
        return new ResponseUtil(200, "OK", service.getCustomerId());
    }

    @GetMapping(path = "get-account-id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAccountId() {
        return new ResponseUtil(200, "OK", service.getAccountId());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil registerUser() {
        return new ResponseUtil(200, "Sign Up Successful", null);
    }

}

