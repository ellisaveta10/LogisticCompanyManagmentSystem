package com.example.project.services.implementations;

import com.example.project.data.dto.*;
import com.example.project.data.entity.*;
import com.example.project.data.repository.*;
import com.example.project.services.LogisticsCompanyService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LogisticsCompanyServiceImpl implements LogisticsCompanyService {

    private final LogisticsCompanyRepository logisticsCompanyRepository;
    private final ClientsRepository clientsRepository;
    private final CourierEmployeeRepository courierEmployeeRepository;
    private final OfficeEmployeeRepository officeEmployeeRepository;
    private final ShipmentRepository shipmentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<LogisticsCompanyDTO> getLogisticsCompanies() {
        return logisticsCompanyRepository.findAll().stream()
                .map(this::convertToLogisticsCompanyDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<LogisticsCompanyDTO> getLogisticsCompanies2() {
        return logisticsCompanyRepository.findAll().stream()
                .map(this::convertToLogisticsCompanyDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<LogisticsCompanyDTO> getLogisticsCompanies3() {
        return logisticsCompanyRepository.findAll().stream()
                .map(this::convertToLogisticsCompanyDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<LogisticsCompanyDTO> getLogisticsCompanies4() {
        return logisticsCompanyRepository.findAll().stream()
                .map(this::convertToLogisticsCompanyDTO)
                .collect(Collectors.toList());
    }


    @Override
    public LogisticsCompanyDTO getLogisticCompany(long id) {
        return modelMapper
                .map(logisticsCompanyRepository.findById(id).orElseThrow(()
                        -> new IllegalArgumentException("Invalid Logistics Company ID: " + id)),
                        LogisticsCompanyDTO.class);
    }

    @Override
    public LogisticsCompany getLogisticCompany2(long id) {
        return logisticsCompanyRepository.getById(id);
    }


    @Override
    public LogisticsCompany create(CreateLogisticsCompanyDTO createLogisticsCompanyDTO) {
        return logisticsCompanyRepository.save(modelMapper.map(createLogisticsCompanyDTO, LogisticsCompany.class));
    }

    @Override
    public LogisticsCompany updateLogisticCompany(long id, UpdateLogisticsCompanyDTO logisticsCompanyDTO) {
        LogisticsCompany logisticsCompany1 = modelMapper.map(logisticsCompanyDTO, LogisticsCompany.class);
        logisticsCompany1.setId(id);
        return  logisticsCompanyRepository.save(logisticsCompany1);
    }

    @Override
    public void deleteLogisticCompany(long id) {
        logisticsCompanyRepository.deleteById(id);
    }

    private LogisticsCompanyDTO convertToLogisticsCompanyDTO(LogisticsCompany logisticsCompany) {
              return modelMapper.map(logisticsCompany, LogisticsCompanyDTO.class);
    }

    private ClientsDTO convertToClientsDTO(Clients clients) {
        return modelMapper.map(clients, ClientsDTO.class);
    }

    private CourierEmployeeDTO convertToCourierEmployeesDTO(CourierEmployee courierEmployee) {
        return modelMapper.map(courierEmployee, CourierEmployeeDTO.class);
    }

    private OfficeEmployeeDTO convertToOfficeEmployeesDTO(OfficeEmployee officeEmployee) {
        return modelMapper.map(officeEmployee, OfficeEmployeeDTO.class);
    }

    private ShipmentDTO convertToShipmentsDTO(Shipment shipment) {
        return modelMapper.map(shipment, ShipmentDTO.class);
    }

    @Override
    public List<ClientsDTO> getClientsList() {
        return clientsRepository.findAll().stream()
                .map(this::convertToClientsDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CourierEmployeeDTO> getCouriersList() {
        return courierEmployeeRepository.findAll().stream()
                .map(this::convertToCourierEmployeesDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<OfficeEmployeeDTO> getOfficeEmployeesList() {
        return officeEmployeeRepository.findAll().stream()
                .map(this::convertToOfficeEmployeesDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ShipmentDTO> getShipmentsList() {
        return shipmentRepository.findAll().stream()
                .map(this::convertToShipmentsDTO)
                .collect(Collectors.toList());
    }

    /*@Override
    public List<ClientsDTO> getClientsListByCompanyId(long id) {
        return logisticsCompanyRepository.findAllById(id);
    }*/
}
