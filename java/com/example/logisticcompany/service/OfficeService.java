package com.example.logisticcompany.service;

import com.example.logisticcompany.model.Customer;
import com.example.logisticcompany.model.Office;

import java.util.Optional;
import java.util.UUID;

public interface OfficeService {

    public Iterable<Office> findAll();

    public Optional<Office> findById(UUID id);

    public Office save(Office entity);

    public Iterable<Office> saveAll(Iterable<Office> office);

    public void delete(Office office);

    public void deleteById(UUID id);
}
