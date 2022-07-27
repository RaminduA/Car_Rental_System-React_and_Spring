package com.scorpion.easycar.controller;

import com.scorpion.easycar.datatransfer.CustomerDTO;
import com.scorpion.easycar.datatransfer.RentRequestDTO;
import com.scorpion.easycar.service.CustomerProfileService;
import com.scorpion.easycar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@CrossOrigin
@RequestMapping("api/customer-profile")
public class CustomerProfileController {

    @Autowired
    private CustomerProfileService service;

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseUtil updateDisplayPicture(@RequestPart("displayPicture") MultipartFile displayPicture){
        try{
            service.updateDisplayPicture(displayPicture.getBytes());
            return new ResponseUtil(200, "OK", null);
        }catch (IOException e){
            e.printStackTrace();
            return new ResponseUtil(500, "Error", null);
        }
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updatePersonalDetails(@RequestBody CustomerDTO dto){
        service.updatePersonalDetails(dto);
        return new ResponseUtil(200, "Updated", null);
    }
}

