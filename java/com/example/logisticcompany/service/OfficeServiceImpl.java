package com.example.logisticcompany.service;

import com.example.logisticcompany.model.Customer;
import com.example.logisticcompany.model.Office;
import com.example.logisticcompany.model.User;
import com.example.logisticcompany.repository.CustomerRepository;
import com.example.logisticcompany.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OfficeServiceImpl implements OfficeService{
    private final OfficeRepository officeRepository;

    @Autowired
    public OfficeServiceImpl(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    @Override
    public Office save(Office office) {
        return officeRepository.save(office);
    }

    @Override
    public Iterable<Office> findAll() {
        return officeRepository.findAll();
    }

    @Override
    public Optional<Office> findById(UUID id) {
        return officeRepository.findById(id);
    }


    @Override
    public Iterable<Office> saveAll(Iterable<Office> items) {
        return officeRepository.saveAll(items);
    }

    @Override
    public void delete(Office entity)  {
        officeRepository.delete(entity);
    }

    @Override
    public void deleteById(UUID id) {
        officeRepository.deleteById(id);
    }
}
