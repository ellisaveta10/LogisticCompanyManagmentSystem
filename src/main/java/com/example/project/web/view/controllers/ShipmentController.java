package com.example.project.web.view.controllers;

import com.example.project.data.dto.CreateShipmentDTO;
import com.example.project.data.dto.ShipmentDTO;
import com.example.project.data.dto.UpdateShipmentDTO;
import com.example.project.data.entity.OfficeEmployee;
import com.example.project.data.entity.Shipment;
import com.example.project.services.AddressService;
import com.example.project.services.ClientsService;
import com.example.project.services.OfficeEmployeeService;
import com.example.project.services.ShipmentService;
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
@RequestMapping("/shipments")
public class ShipmentController {
    private ShipmentService shipmentService;
    private OfficeEmployeeService officeEmployeeService;
    private final ModelMapper modelMapper;
    private AddressService addressService;
    private ClientsService clientsService;

    @GetMapping
    public String getShipments(Model model){
        final List<ShipmentViewModel> shipments = shipmentService.getShipments()
                        .stream().map(this::convertToShipmentViewModel)
                        .collect(Collectors.toList());
        model.addAttribute("shipments", shipments);
        return "/shipments/shipments.html";
    }

    @GetMapping("/create-shipment")
    public String showCreateShipmentForm(Model model){
        model.addAttribute("shipment", new CreateShipmentViewModel());
        model.addAttribute("addresses", addressService.getAddresses());
        model.addAttribute("clients", clientsService.getClients());
        model.addAttribute("officeEmployees", officeEmployeeService.getOfficeEmployees());
        return "/shipments/create-shipment";
    }

    @PostMapping("/create")
    public String createShipment(@Valid @ModelAttribute("shipment") CreateShipmentViewModel shipment,
                                 BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "shipments/create-shipment";
        }
        model.addAttribute("shipment", new CreateShipmentViewModel());
        model.addAttribute("addresses", addressService.getAddresses());
        model.addAttribute("clients", clientsService.getClients());
        model.addAttribute("officeEmployees", officeEmployeeService.getOfficeEmployees());
        shipmentService.create(modelMapper.map(shipment, CreateShipmentDTO.class));
        return "redirect:/shipments";
    }

    @GetMapping("/edit-shipment/{id}")
    public String showEditShipmentForm(Model model, @PathVariable Long id){
        model.addAttribute("addresses", addressService.getAddresses());
        model.addAttribute("clients", clientsService.getClients());
        model.addAttribute("officeEmployees", officeEmployeeService.getOfficeEmployees());
        model.addAttribute("shipment", modelMapper.map(shipmentService.getShipment(id),
                UpdateShipmentViewModel.class));
        return "/shipments/edit-shipment";
    }

    @PostMapping("/update/{id}")
    public String updateShipment(@PathVariable long id, @Valid @ModelAttribute("shipment") UpdateShipmentViewModel shipment,
                                 BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "shipments/edit-shipment";
        }
        model.addAttribute("addresses", addressService.getAddresses());
        model.addAttribute("clients", clientsService.getClients());
        model.addAttribute("officeEmployees", officeEmployeeService.getOfficeEmployees());
        shipmentService.updateShipment(id, modelMapper.map(shipment, UpdateShipmentDTO.class));
        return "redirect:/shipments";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id){
        shipmentService.deleteShipment(id);
        return "redirect:/shipments";
    }

    private ShipmentViewModel convertToShipmentViewModel(ShipmentDTO shipmentDTO) {
        return modelMapper.map(shipmentDTO, ShipmentViewModel.class);
    }
}
