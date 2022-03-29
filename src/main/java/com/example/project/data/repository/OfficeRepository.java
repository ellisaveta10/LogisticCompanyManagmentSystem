package com.example.project.data.repository;

import com.example.project.data.entity.Address;
import com.example.project.data.entity.CourierEmployee;
import com.example.project.data.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfficeRepository extends JpaRepository<Office, Long> {

}
