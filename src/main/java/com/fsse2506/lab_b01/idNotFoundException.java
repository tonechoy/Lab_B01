package com.fsse2506.lab_b01;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class idNotFoundException extends RuntimeException {
    public idNotFoundException(String hkid) {
        super("Person not found: " + hkid);
    }
}
