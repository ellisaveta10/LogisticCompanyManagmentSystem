package com.example.project.data.repository;

import com.example.project.data.entity.Clients;
import com.example.project.data.entity.CourierEmployee;
import com.example.project.data.entity.LogisticsCompany;
import com.example.project.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LogisticsCompanyRepository extends JpaRepository<LogisticsCompany, Long> {
    List<LogisticsCompany> findAllByName(String name);

    /*@Query("SELECT l FROM LogisticsCompany l where l.id = ?1")
    LogisticsCompany findByLogisticsCompanyById(long id);*/
}
