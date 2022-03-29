package com.example.project.services;

import com.example.project.data.dto.CourierEmployeeDTO;
import com.example.project.data.dto.CreateCourierEmployeeDTO;
import com.example.project.data.dto.LogisticsCompanyDTO;
import com.example.project.data.dto.UpdateCourierEmployeeDTO;
import com.example.project.data.entity.CourierEmployee;
import com.example.project.data.entity.LogisticsCompany;

import java.util.List;

public interface CourierEmployeeService {

    List<CourierEmployeeDTO> getCourierEmployees();

    CourierEmployeeDTO getCourierEmployee(long id);

    CourierEmployee create(CreateCourierEmployeeDTO createCourierEmployeeDTO);

    CourierEmployee updateCourierEmployee(long id, UpdateCourierEmployeeDTO updateCourierEmployeeDTO);

    void deleteCourierEmployee(long id);

    List<LogisticsCompany> listLogisticCompanies();

    List<CourierEmployee> findAllByName(String name);

    void save(CourierEmployee courierEmployee);

    List<CourierEmployee> findAllByLogisticsCompany(LogisticsCompany logisticsCompany);

    //List<CourierEmployee>findAllByName(String name);

}
