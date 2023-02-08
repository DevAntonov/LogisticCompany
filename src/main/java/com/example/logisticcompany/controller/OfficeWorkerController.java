package com.example.logisticcompany.controller;

import com.example.logisticcompany.model.Customer;
import com.example.logisticcompany.service.CompanyService;
import com.example.logisticcompany.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OfficeWorkerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    CompanyService companyService;

    @RequestMapping(value = {"/office/dashboard"}, method = RequestMethod.GET)
    public String adminHome(){
        return "office/dashboard";
    }

    @RequestMapping(value = {"/office/customer"}, method = RequestMethod.GET)
    public String officeCompany(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        model.addAttribute("customerName", customer.getName());
        return "/office/customers";
    }

    @RequestMapping(value = {"/office/customer"}, method = RequestMethod.POST)
    public String employeeAddCustomer(Model model, @Valid Customer customer){

        customerService.save(customer);
        return "/office/dashboard";
    }
}
