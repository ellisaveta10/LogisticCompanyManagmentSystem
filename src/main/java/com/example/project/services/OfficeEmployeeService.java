package com.example.project.services;

import com.example.project.data.dto.CreateOfficeEmployeeDTO;
import com.example.project.data.dto.OfficeEmployeeDTO;
import com.example.project.data.dto.ShipmentDTO;
import com.example.project.data.dto.UpdateOfficeEmployeeDTO;
import com.example.project.data.entity.CourierEmployee;
import com.example.project.data.entity.LogisticsCompany;
import com.example.project.data.entity.OfficeEmployee;
import java.util.List;

public interface OfficeEmployeeService {

    List<OfficeEmployeeDTO> getOfficeEmployees();

    OfficeEmployeeDTO getOfficeEmployee(long id);

    OfficeEmployee getOfficeEmployee2(long id);

    OfficeEmployee create(CreateOfficeEmployeeDTO createOfficeEmployeeDTO);

    OfficeEmployee updateOfficeEmployee(long id, UpdateOfficeEmployeeDTO updateOfficeEmployeeDTO);

    void deleteOfficeEmployee(long id);

    List<LogisticsCompany> listLogisticCompanies();

    List<OfficeEmployee> findAllByLogisticsCompany(LogisticsCompany logisticsCompany);

    List<ShipmentDTO> getShipmentsList();
}
