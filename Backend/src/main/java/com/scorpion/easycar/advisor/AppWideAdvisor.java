package com.scorpion.easycar.advisor;

import com.scorpion.easycar.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AppWideAdvisor {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseUtil> exceptionHandler(Exception e){
        return new ResponseEntity<>(new ResponseUtil(500, e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
