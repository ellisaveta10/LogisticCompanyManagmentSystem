package com.example.project.services.implementations;

import com.example.project.data.dto.ClientsDTO;
import com.example.project.data.dto.CreateClientsDTO;
import com.example.project.data.dto.LogisticsCompanyDTO;
import com.example.project.data.dto.UpdateClientsDTO;
import com.example.project.data.entity.Clients;
import com.example.project.data.entity.LogisticsCompany;
import com.example.project.data.repository.ClientsRepository;
import com.example.project.data.repository.LogisticsCompanyRepository;
import com.example.project.services.ClientsService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientsServiceImpl implements ClientsService {
    
    private final ClientsRepository clientsRepository;
    private final LogisticsCompanyRepository logisticsCompanyRepository;
    private final ModelMapper modelMapper;

    @Override
    public List <ClientsDTO> getClients() {
        return clientsRepository.findAll().stream()
                .map(this::convertToClientsDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClientsDTO getClient(long id) {
        return modelMapper
                .map(clientsRepository.findById(id).orElseThrow(()
                                -> new IllegalArgumentException("Invalid Client ID: " + id)),
                        ClientsDTO.class);
    }

    @Override
    public Clients create(CreateClientsDTO createClientsDTO) {
        return clientsRepository.save(modelMapper.map(createClientsDTO, Clients.class));
    }

    @Override
    public Clients updateClient(long id, UpdateClientsDTO updateClientsDTO) {
        Clients client1 = modelMapper.map(updateClientsDTO, Clients.class);
        client1.setId(id);
        return clientsRepository.save(client1);
    }

    @Override
    public void deleteClient(long id) {
        clientsRepository.deleteById(id);
    }

    @Override
    public List<Clients> findAllByName(String name){
        return clientsRepository.findAllByName(name);
    }

    private ClientsDTO convertToClientsDTO(Clients clients) {
        return modelMapper.map(clients, ClientsDTO.class);
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
    public List<Clients> listComp(LogisticsCompany logisticsCompany) {
        return clientsRepository.findAllByLogisticsCompaniesContaining(logisticsCompany);
    }

    /* public void registerDefaultCompany(LogisticsCompany logisticsCompany) {
        Clients clients = clientsRepository.getById(1L);
        logisticsCompany.addClient(clients);
        clientsRepository.save(clients);
    }*/

    @Override
    public Clients getClient2(long id) {
        return clientsRepository.getById(id);
    }

    @Override
    public void save(Clients clients) {
        clientsRepository.save(clients);
    }
}
