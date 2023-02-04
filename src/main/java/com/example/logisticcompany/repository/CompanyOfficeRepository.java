package com.example.logisticcompany.repository;

import com.example.logisticcompany.model.CompanyOffice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyOfficeRepository extends JpaRepository<CompanyOffice, UUID> {
}
