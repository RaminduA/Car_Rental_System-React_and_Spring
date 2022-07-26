package com.scorpion.easycar.controller;


import com.scorpion.easycar.datatransfer.CarDTO;
import com.scorpion.easycar.service.CarService;
import com.scorpion.easycar.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@RestController
@RequestMapping("api/v1/car")
@CrossOrigin
public class CarController {

    @Autowired
    CarService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCars() {
        return new ResponseUtil(200, "Ok", service.getAllCars());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCar(CarDTO dto) {
        service.saveCar(dto);
        return new ResponseUtil(200, "Saved", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCar(@RequestBody CarDTO dto) {
        service.updateCar(dto);
        return new ResponseUtil(200, "Updated", null);
    }

    @DeleteMapping(params = {"registrationNo"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCar(@RequestParam String registrationNo) {
        service.deleteCar(registrationNo);
        return new ResponseUtil(200, "deleted", null);
    }

    @GetMapping(path = "/{registrationNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCar(@PathVariable String registrationNo) {
        return new ResponseUtil(200, "Ok", service.getCar(registrationNo));
    }

    @PutMapping(path = "/updateCarStatus/{registrationNO}/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCarStatus(@PathVariable String registrationNO, @PathVariable String status) {
        service.updateStatus(registrationNO, status);
        return new ResponseUtil(200, "Ok", null);
    }

    @GetMapping(path = "/getByStatus/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCarsByStatus(@PathVariable String status) {
        return new ResponseUtil(200, "Ok", service.getAllByStatus(status));
    }

    @GetMapping(path = "/count/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getCountOfCarsByStatus(@PathVariable String status) {
        return new ResponseUtil(200, "Ok", service.getCountByStatus(status));
    }

    @PutMapping(path = "/up/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil uploadImagesAndPath(@RequestPart("frontView")MultipartFile frontView, @RequestPart("rearView")MultipartFile rearView, @RequestPart("lateralView")MultipartFile lateralView, @RequestPart("interiorView")MultipartFile interiorView, @RequestPart("displayPicture")MultipartFile displayPicture, @PathVariable String id){
        try{
            String projectPath = String.valueOf(new File("C:/Users/RAMINDU/Desktop/Final Project - 2nd Sem/Application/Car Rental System"));
            File uploadDirectory = new File(projectPath + "/Cars");
            if(uploadDirectory.mkdir()){
                frontView.transferTo(new File(uploadDirectory.getAbsolutePath() + "/" + frontView.getOriginalFilename()));
                rearView.transferTo(new File(uploadDirectory.getAbsolutePath() + "/" + rearView.getOriginalFilename()));
                lateralView.transferTo(new File(uploadDirectory.getAbsolutePath() + "/" + lateralView.getOriginalFilename()));
                interiorView.transferTo(new File(uploadDirectory.getAbsolutePath() + "/" + interiorView.getOriginalFilename()));
                displayPicture.transferTo(new File(uploadDirectory.getAbsolutePath() + "/" + displayPicture.getOriginalFilename()));

                /*String frontViewPath = projectPath + "/Cars/" + frontView.getOriginalFilename();
                String rearViewPath = projectPath + "/Cars/" + rearView.getOriginalFilename();
                String lateralViewPath = projectPath + "/Cars/" + lateralView.getOriginalFilename();
                String interiorViewPath = projectPath + "/Cars/" + interiorView.getOriginalFilename();
                String displayPicturePath = projectPath + "/Cars/" + displayPicture.getOriginalFilename();*/

                //service.updatePictures(frontViewPath, rearViewPath, lateralViewPath, interiorViewPath, displayPicturePath, id);
                service.updatePictures(frontView.getBytes(), rearView.getBytes(), lateralView.getBytes(), interiorView.getBytes(), displayPicture.getBytes(), id);

                return new ResponseUtil(200, "Uploaded", null);
            }
            return new ResponseUtil(200, "Uploading Failed", null);

        }catch (IOException e){
            e.printStackTrace();
            return new ResponseUtil(500, "Error", null);
        }
    }
}
