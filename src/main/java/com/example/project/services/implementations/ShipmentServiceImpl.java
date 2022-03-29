package com.example.project.services.implementations;

import com.example.project.data.dto.CreateShipmentDTO;
import com.example.project.data.dto.ShipmentDTO;
import com.example.project.data.dto.UpdateShipmentDTO;
import com.example.project.data.entity.Clients;
import com.example.project.data.entity.LogisticsCompany;
import com.example.project.data.entity.OfficeEmployee;
import com.example.project.data.entity.Shipment;
import com.example.project.data.repository.LogisticsCompanyRepository;
import com.example.project.data.repository.ShipmentRepository;
import com.example.project.services.ShipmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepository;
    private final LogisticsCompanyRepository logisticsCompanyRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ShipmentDTO> getShipments() {
        return shipmentRepository.findAll()
                .stream().map(this::convertToShipmentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ShipmentDTO getShipment(long id) {
        return modelMapper.map(shipmentRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Invalid Shipment ID: " + id)), ShipmentDTO.class);
    }

    @Override
    public Shipment create(CreateShipmentDTO createShipmentDTO) {
        return shipmentRepository.save(modelMapper.map(createShipmentDTO, Shipment.class));
    }

    @Override
    public Shipment updateShipment(long id, UpdateShipmentDTO updateShipmentDTO) {
        Shipment shipment = modelMapper.map(updateShipmentDTO, Shipment.class);
        shipment.setId(id);
        return shipmentRepository.save(shipment);
    }

    @Override
    public void deleteShipment(long id) {
        shipmentRepository.deleteById(id);
    }

    private ShipmentDTO convertToShipmentDTO(Shipment shipment) {
        return modelMapper.map(shipment, ShipmentDTO.class);
    }

    private LogisticsCompany convertToCompanies(LogisticsCompany logisticsCompany) {
        return modelMapper.map(logisticsCompany, LogisticsCompany.class);
    }

    @Override
    public List<Shipment> getAllShipmentsForOfficeEmployee(OfficeEmployee officeEmployee) {
        return shipmentRepository.findAllByOfficeEmployee(officeEmployee);
    }

    @Override
    public List<LogisticsCompany> listLogisticCompanies() {
        return logisticsCompanyRepository.findAll().stream()
                .map(this::convertToCompanies)
                .collect(Collectors.toList());
    }

    @Override
    public List<Shipment> findAllByLogisticsCompany(LogisticsCompany logisticsCompany) {
        return shipmentRepository.findAllByLogisticsCompany(logisticsCompany);
    }

    @Override
    public List<Shipment> getAllShipmentsForClient(Clients client, Clients client1) {
        return shipmentRepository.findAllBySenderOrReceiver(client, client1);
    }

}
