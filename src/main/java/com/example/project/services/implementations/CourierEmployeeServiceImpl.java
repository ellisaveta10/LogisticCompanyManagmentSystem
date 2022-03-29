package com.example.project.services.implementations;

import com.example.project.data.dto.*;
import com.example.project.data.entity.CourierEmployee;
import com.example.project.data.entity.LogisticsCompany;
import com.example.project.data.repository.CourierEmployeeRepository;
import com.example.project.data.repository.LogisticsCompanyRepository;
import com.example.project.services.CourierEmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CourierEmployeeServiceImpl implements CourierEmployeeService {

    private final CourierEmployeeRepository courierEmployeeRepository;
    private final LogisticsCompanyRepository logisticsCompanyRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CourierEmployeeDTO> getCourierEmployees() {
        return courierEmployeeRepository.findAll().stream()
                .map(this::convertToCourierEmployeeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CourierEmployeeDTO getCourierEmployee(long id) {
        return modelMapper.map(courierEmployeeRepository.findById(id).orElseThrow(()
                ->new IllegalArgumentException("Invalid Courier Employee ID: " + id)), CourierEmployeeDTO.class);
    }

    @Override
    public CourierEmployee create(CreateCourierEmployeeDTO createCourierEmployeeDTO) {
        return courierEmployeeRepository.save(modelMapper.map(createCourierEmployeeDTO, CourierEmployee.class));
    }

    @Override
    public CourierEmployee updateCourierEmployee(long id, UpdateCourierEmployeeDTO updateCourierEmployeeDTO) {
        CourierEmployee courierEmployee=modelMapper.map(updateCourierEmployeeDTO, CourierEmployee.class);
        courierEmployee.setId(id);
        return courierEmployeeRepository.save(courierEmployee);
    }

    @Override
    public void deleteCourierEmployee(long id) {
        courierEmployeeRepository.deleteById(id);
    }

    @Override
    public List<CourierEmployee> findAllByName(String name) {
        return courierEmployeeRepository.findAllByName(name);
    }

    private CourierEmployeeDTO convertToCourierEmployeeDTO(CourierEmployee courierEmployee) {
        return modelMapper.map(courierEmployee, CourierEmployeeDTO.class);
    }

    private LogisticsCompany convertToCompanies(LogisticsCompany logisticsCompany) {
        return modelMapper.map(logisticsCompany, LogisticsCompany.class);
    }

    @Override
    public List<LogisticsCompany> listLogisticCompanies() {
        return logisticsCompanyRepository.findAll().stream()
                .map(this::convertToCompanies)
                .collect(Collectors.toList());
    }

    @Override
    public void save(CourierEmployee courierEmployee) {
        courierEmployeeRepository.save(courierEmployee);
    }

    @Override
    public List<CourierEmployee> findAllByLogisticsCompany(LogisticsCompany logisticsCompany) {
        return courierEmployeeRepository.findAllByLogisticsCompany(logisticsCompany);
    }
}