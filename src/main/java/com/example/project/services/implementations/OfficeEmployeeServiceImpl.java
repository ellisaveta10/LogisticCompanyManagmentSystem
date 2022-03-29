package com.example.project.services.implementations;

import com.example.project.data.dto.*;
import com.example.project.data.entity.*;
import com.example.project.data.repository.CourierEmployeeRepository;
import com.example.project.data.repository.LogisticsCompanyRepository;
import com.example.project.data.repository.OfficeEmployeeRepository;
import com.example.project.data.repository.ShipmentRepository;
import com.example.project.services.OfficeEmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OfficeEmployeeServiceImpl implements OfficeEmployeeService {

    private final OfficeEmployeeRepository officeEmployeeRepository;
    private final LogisticsCompanyRepository logisticsCompanyRepository;
    private final ShipmentRepository shipmentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<OfficeEmployeeDTO> getOfficeEmployees() {
        return officeEmployeeRepository.findAll().stream()
                .map(this::convertToOfficeEmployeeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OfficeEmployeeDTO getOfficeEmployee(long id) {
        return modelMapper.map(officeEmployeeRepository.findById(id).orElseThrow(()
                ->new IllegalArgumentException("Invalid Office Employee ID: " + id)), OfficeEmployeeDTO.class);
    }

    @Override
    public OfficeEmployee create(CreateOfficeEmployeeDTO createOfficeEmployeeDTO) {
        return officeEmployeeRepository.save(modelMapper.map(createOfficeEmployeeDTO, OfficeEmployee.class));
    }

    @Override
    public OfficeEmployee updateOfficeEmployee(long id, UpdateOfficeEmployeeDTO updateOfficeEmployeeDTO) {
        OfficeEmployee officeEmployee=modelMapper.map(updateOfficeEmployeeDTO, OfficeEmployee.class);
        officeEmployee.setId(id);
        return officeEmployeeRepository.save(officeEmployee);
    }

    @Override
    public void deleteOfficeEmployee(long id) {
        officeEmployeeRepository.deleteById(id);
    }

    /*@Override
    public List<CourierEmployee> findAllByName(String name) {
        return null;
    }*/

    private OfficeEmployeeDTO convertToOfficeEmployeeDTO(OfficeEmployee officeEmployee) {
        return modelMapper.map(officeEmployee, OfficeEmployeeDTO.class);
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

    private ShipmentDTO convertToShipmentsDTO(Shipment shipment) {
        return modelMapper.map(shipment, ShipmentDTO.class);
    }

    @Override
    public List<ShipmentDTO> getShipmentsList() {
        return shipmentRepository.findAll().stream()
                .map(this::convertToShipmentsDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<OfficeEmployee> findAllByLogisticsCompany(LogisticsCompany logisticsCompany) {
        return officeEmployeeRepository.findAllByLogisticsCompany(logisticsCompany);
    }

    @Override
    public OfficeEmployee getOfficeEmployee2(long id) {
        return officeEmployeeRepository.getById(id);
    }
}
