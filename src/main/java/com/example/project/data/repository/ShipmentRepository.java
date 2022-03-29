package com.example.project.data.repository;

import com.example.project.data.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
    List<Shipment> findAllByOfficeEmployee(OfficeEmployee officeEmployee);
    List<Shipment> findAllBySenderOrReceiver(Clients client, Clients client2);
    List<Shipment> findAllByLogisticsCompany(LogisticsCompany logisticsCompany);
}
