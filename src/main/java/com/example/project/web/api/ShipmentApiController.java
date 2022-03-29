package com.example.project.web.api;

import com.example.project.data.dto.CreateShipmentDTO;
import com.example.project.data.dto.ShipmentDTO;
import com.example.project.data.dto.UpdateShipmentDTO;
import com.example.project.data.entity.Shipment;
import com.example.project.services.ShipmentService;
import com.example.project.web.view.model.CreateShipmentViewModel;
import com.example.project.web.view.model.ShipmentViewModel;
import com.example.project.web.view.model.UpdateShipmentViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ShipmentApiController {

    private final ShipmentService shipmentService;
    private final ModelMapper modelMapper;

    /*public ShipmentApiController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }*/

    @GetMapping(value = "/api/shipment")
    public List<ShipmentDTO> getShipments() {
        return shipmentService.getShipments();
    }

    @RequestMapping("/api/shipment/{id}")
    public ShipmentDTO getShipment(@PathVariable("id") int id) {
        return shipmentService.getShipment(id);
    }

    @PostMapping(value = "/api/shipment")
    public Shipment createShipment(@RequestBody CreateShipmentViewModel shipment) {
        return shipmentService.create(modelMapper.map(shipment, CreateShipmentDTO.class));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/api/shipment/{id}")
    public Shipment updateShipment(@PathVariable("id") long id, @RequestBody UpdateShipmentViewModel shipment) {
        return shipmentService.updateShipment(id, modelMapper.map(shipment, UpdateShipmentDTO.class));
    }

    @DeleteMapping(value = "/api/shipment/{id}")
    public void deleteShipment(@PathVariable long id) {
        shipmentService.deleteShipment(id);
    }




}
