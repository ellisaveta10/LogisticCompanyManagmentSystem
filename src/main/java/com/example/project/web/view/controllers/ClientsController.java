package com.example.project.web.view.controllers;

import com.example.project.data.dto.*;
import com.example.project.data.entity.Clients;
import com.example.project.data.entity.LogisticsCompany;
import com.example.project.data.entity.Shipment;
import com.example.project.services.ClientsService;
import com.example.project.services.ShipmentService;
import com.example.project.services.implementations.LogisticsCompanyServiceImpl;
import com.example.project.web.view.model.*;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/clients")
public class ClientsController {
    private ClientsService clientsService;
    private LogisticsCompanyServiceImpl service;
    private final ModelMapper modelMapper;
    private ShipmentService shipmentService;


    @GetMapping
    public String getClients(Model model) {
        final List<ClientsViewModel> clients = clientsService.getClients()
                .stream().map(this::convertToClientsViewModel)
                .collect(Collectors.toList());
        model.addAttribute("clients", clients);
        return "/clients/clients.html";
    }

    @GetMapping("/create-client")
    public String showCreateClientsForm(Model model) {
        model.addAttribute("client", new CreateClientsViewModel());
        List<LogisticsCompanyDTO> logisticsCompanies = service.getLogisticsCompanies();
        model.addAttribute("logisticsCompanies", logisticsCompanies);
        return "/clients/create-client";
    }

    @PostMapping("/create")
    public String createClient(@Valid @ModelAttribute("client")
                                           CreateClientsViewModel client,
                               BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "clients/create-client";
        }
        List<LogisticsCompanyDTO> logisticsCompanies = service.getLogisticsCompanies();
        model.addAttribute("logisticsCompanies", logisticsCompanies);
        clientsService.create(modelMapper.map(client, CreateClientsDTO.class));
        return "redirect:/clients";
    }

    @GetMapping("/edit-client/{id}")
    public String showEditClientsForm(Model model, @PathVariable Long id) {
        model.addAttribute("client", modelMapper.map(clientsService.getClient(id),
                UpdateClientsViewModel.class));
        List<LogisticsCompanyDTO> logisticsCompanies = service.getLogisticsCompanies();
        model.addAttribute("logisticsCompanies", logisticsCompanies);
        return "/clients/edit-client";
    }

    @PostMapping("/update/{id}")
    public String updateClient(@PathVariable long id, @Valid @ModelAttribute("client")
            UpdateClientsViewModel client, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "/clients/edit-client";
        }
        clientsService.updateClient(id, modelMapper.map(client, UpdateClientsDTO.class));
        List<LogisticsCompanyDTO> logisticsCompanies = service.getLogisticsCompanies();
        model.addAttribute("logisticsCompanies", logisticsCompanies);
        return "redirect:/clients";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id) {
        clientsService.deleteClient(id);
        return "redirect:/clients";
    }

    private ClientsViewModel convertToClientsViewModel(ClientsDTO clientsDTO) {
        return modelMapper.map(clientsDTO, ClientsViewModel.class);
    }

    @GetMapping("/selectClient")
    public String getOfficeClients(Model model){
        final List<ClientsViewModel> clients = clientsService.getClients()
                .stream().map(this::convertToClientsViewModel)
                .collect(Collectors.toList());
        model.addAttribute("clients", clients);
        return "/clients/selectClientForShipments";
    }

    @GetMapping("/referenceForShipmentsForClient/{id}")
    public String getClientShipments(@PathVariable("id") long id, Model model) {
        Clients client = clientsService.getClient2(id);
        Clients client1 = clientsService.getClient2(id);
        model.addAttribute("client", client);
        List<Shipment> shipmentList = shipmentService.getAllShipmentsForClient(client, client1);
        model.addAttribute("shipmentList", shipmentList);
        return "clients/referenceForShipments";


    }
}
