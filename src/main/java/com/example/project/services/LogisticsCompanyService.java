package com.example.project.services;

import com.example.project.data.dto.*;
import com.example.project.data.entity.Clients;
import com.example.project.data.entity.LogisticsCompany;
import java.util.List;

public interface LogisticsCompanyService {

    List<LogisticsCompanyDTO> getLogisticsCompanies();

    List<LogisticsCompanyDTO> getLogisticsCompanies2();

    List<LogisticsCompanyDTO> getLogisticsCompanies3();

    List<LogisticsCompanyDTO> getLogisticsCompanies4();

    LogisticsCompany getLogisticCompany2(long id);

    LogisticsCompanyDTO getLogisticCompany(long id);

    LogisticsCompany create(CreateLogisticsCompanyDTO createLogisticsCompanyDTO);

    LogisticsCompany updateLogisticCompany(long id, UpdateLogisticsCompanyDTO updateLogisticsCompanyDTO);

    void deleteLogisticCompany(long id);

    //List<LogisticsCompany> getLogisticsCompany();

    List<ClientsDTO> getClientsList();

    List<CourierEmployeeDTO> getCouriersList();

    List<OfficeEmployeeDTO> getOfficeEmployeesList();

    List<ShipmentDTO> getShipmentsList();

    //List<ClientsDTO> getClientsListByCompanyId(long id);
}
