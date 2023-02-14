package com.example.logisticcompany.repository;

import com.example.logisticcompany.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OfficeRepository extends JpaRepository<Office, UUID> {
}
