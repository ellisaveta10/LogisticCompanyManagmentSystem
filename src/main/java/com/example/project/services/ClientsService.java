package com.example.project.services;

import com.example.project.data.dto.ClientsDTO;
import com.example.project.data.dto.CreateClientsDTO;
import com.example.project.data.dto.LogisticsCompanyDTO;
import com.example.project.data.dto.UpdateClientsDTO;
import com.example.project.data.entity.Clients;
import com.example.project.data.entity.LogisticsCompany;

import java.util.List;

public interface ClientsService {

    List<ClientsDTO> getClients();

    ClientsDTO getClient(long id);

    Clients create(CreateClientsDTO createClientsDTO);

    Clients updateClient(long id, UpdateClientsDTO updateClientsDTO);

    void deleteClient(long id);

    List<Clients>findAllByName(String name);

    List<LogisticsCompany> listLogisticCompanies();

    List<Clients> listComp(LogisticsCompany logisticsCompany);

    void save(Clients clients);

    Clients getClient2(long id);

}
