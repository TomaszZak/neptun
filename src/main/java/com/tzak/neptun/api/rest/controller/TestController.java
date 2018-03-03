package com.tzak.neptun.api.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class TestController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return this.getClass().getSimpleName() + "-> Home !!";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return this.getClass().getSimpleName() + "-> test";
    }

    @RequestMapping(value = "/httpCode500", method = RequestMethod.GET)
    public ResponseEntity httpCode500() {
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/httpOk", method = RequestMethod.GET)
    public ResponseEntity httpOk() {
        return new ResponseEntity(HttpStatus.OK);
    }

}