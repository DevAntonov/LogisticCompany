package com.example.logisticcompany.controller;

import com.example.logisticcompany.model.Customer;
import com.example.logisticcompany.model.Office;
import com.example.logisticcompany.model.User;
import com.example.logisticcompany.service.CustomerService;
import com.example.logisticcompany.service.OfficeService;
import com.example.logisticcompany.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RequestMapping("/office")
@RestController
public class OfficeController {

    @Autowired
    private OfficeService officeService;

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Iterable<Office> getOffices() { return officeService.findAll(); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addOffice(@RequestBody Office office) { officeService.save(office)  ; }

    @GetMapping("/{officeId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Optional<Office> getOfficeById(@PathVariable UUID officeId) { return officeService.findById(officeId); }
}

