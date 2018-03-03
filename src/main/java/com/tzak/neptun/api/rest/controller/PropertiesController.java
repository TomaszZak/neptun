package com.tzak.neptun.api.rest.controller;

import com.tzak.neptun.common.PropertyHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/properties")
@RestController
public class PropertiesController {


    @Autowired
    private PropertyHelper propertyHelper;

    @RequestMapping(value = "/testExternalProperties", method = RequestMethod.GET)
    public String testExternalProperties() {
        return propertyHelper.testExternalProperties();
    }


    @RequestMapping(value = "/testApplicationProperties", method = RequestMethod.GET)
    public String testApplicationProperties() {
        return propertyHelper.testApplicationProperties();
    }

}
