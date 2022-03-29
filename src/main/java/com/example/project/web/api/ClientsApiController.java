package com.example.project.web.api;

import com.example.project.data.dto.ClientsDTO;
import com.example.project.data.dto.CreateClientsDTO;
import com.example.project.data.dto.UpdateClientsDTO;
import com.example.project.data.dto.UpdateLogisticsCompanyDTO;
import com.example.project.data.entity.Clients;
import com.example.project.services.ClientsService;
import com.example.project.web.view.model.CreateClientsViewModel;
import com.example.project.web.view.model.UpdateClientsViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ClientsApiController {

    private final ClientsService clientsService;
    private final ModelMapper modelMapper;

    //private final ModelMapper modelMapper;
    @GetMapping(value = "/api/clients")
    public List<ClientsDTO> getClients() {
        return clientsService.getClients();
    }

    @RequestMapping("/api/clients/{id}")
    public ClientsDTO getClient(@PathVariable("id") int id) {
        return clientsService.getClient(id);
    }

    @PostMapping(value = "/api/clients")
    public Clients createClient(@RequestBody CreateClientsViewModel clients) {
        return clientsService.create(modelMapper.map(clients, CreateClientsDTO.class));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/api/clients/{id}")
    public Clients updateClient(@PathVariable("id") long id, @RequestBody UpdateClientsViewModel clients) {
        return clientsService.updateClient(id, modelMapper.map(clients, UpdateClientsDTO.class));
    }

    @DeleteMapping(value = "/api/clients/{id}")
    public void deleteClient(@PathVariable long id) {
        clientsService.deleteClient(id);
    }


}
