package com.example.logisticcompany.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CourierController {

    @RequestMapping(value = {"/courier/dashboard"}, method = RequestMethod.GET)
    public String adminHome(){
        return "courier/dashboard";
    }
}

