package com.example.logisticcompany.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class ClientController {
    @RequestMapping(value = {"/client/dashboard"}, method = RequestMethod.GET)
    public String clientHome(){
        return "client/dashboard";
    }
}
