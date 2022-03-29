package com.example.project.services;

import com.example.project.data.dto.CreateShipmentDTO;
import com.example.project.data.dto.ShipmentDTO;
import com.example.project.data.dto.UpdateShipmentDTO;
import com.example.project.data.entity.Clients;
import com.example.project.data.entity.LogisticsCompany;
import com.example.project.data.entity.OfficeEmployee;
import com.example.project.data.entity.Shipment;
import java.util.List;

public interface ShipmentService {

    List<ShipmentDTO> getShipments();

    ShipmentDTO getShipment(long id);

    Shipment create(CreateShipmentDTO createShipmentDTO);

    Shipment updateShipment(long id, UpdateShipmentDTO updateShipmentDTO);

    void deleteShipment(long id);

    List<Shipment> getAllShipmentsForOfficeEmployee(OfficeEmployee officeEmployee);

    List<Shipment> findAllByLogisticsCompany(LogisticsCompany logisticsCompany);

    List<LogisticsCompany> listLogisticCompanies();

    List<Shipment> getAllShipmentsForClient(Clients client, Clients client1);
}
