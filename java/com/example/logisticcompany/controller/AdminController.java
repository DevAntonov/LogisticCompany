package com.example.logisticcompany.controller;

import com.example.logisticcompany.exceptions.CompanyWithThatNameAlreadyExistsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.logisticcompany.model.Company;
import com.example.logisticcompany.model.User;
import com.example.logisticcompany.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;


import java.util.List;

@Controller
public class AdminController {

    @Autowired
    CompanyService companyService;
    @RequestMapping(value = {"/admin/dashboard"}, method = RequestMethod.GET)
    public String adminHome(){
        return "admin/dashboard";
    }

    @RequestMapping(value = {"/admin/company"}, method = RequestMethod.GET)
    public String adminCompany(Model model){
        Company company = new Company();
        Iterable<Company> companies = companyService.findAll();
        model.addAttribute("company", company);
        model.addAttribute("companyName", company.getCompanyName());
        model.addAttribute("companies", companies);
        return "admin/company";
    }

    @RequestMapping(value = {"/admin/company"}, method = RequestMethod.POST)
    public String adminAddCompany(Model model, @Valid Company company, BindingResult bindingResult) throws CompanyWithThatNameAlreadyExistsException{
        companyService.save(company);

        return "admin/dashboard";
    }
}
