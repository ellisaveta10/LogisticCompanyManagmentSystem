package com.example.project.web.api;

import com.example.project.data.dto.AddressDTO;
import com.example.project.data.dto.CreateAddressDTO;
import com.example.project.data.dto.UpdateAddressDTO;
import com.example.project.data.entity.Address;
import com.example.project.services.AddressService;
import com.example.project.web.view.model.CreateAddressViewModel;
import com.example.project.web.view.model.UpdateAddressViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/logistics_company")
@AllArgsConstructor

public class AddressApiController {

    private final AddressService addressService;
    private final ModelMapper modelMapper;


    @GetMapping(value = "/api/address")
    public List<AddressDTO> getLogisticCompanies() {
        return addressService.getAddresses();
    }

    @RequestMapping("/api/address/{id}")
    public AddressDTO getAddress(@PathVariable("id") int id) {
        return addressService.getAddress(id);
    }

    @PostMapping(value = "/api/address")
    public Address createAddress(@RequestBody CreateAddressViewModel address) {
        return addressService.create(modelMapper.map(address, CreateAddressDTO.class));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/api/address/{id}")
    public Address updateAddress(@PathVariable("id") long id, @RequestBody UpdateAddressViewModel address) {
        return addressService.updateAddress(id, modelMapper.map(address, UpdateAddressDTO.class));
    }

    @DeleteMapping(value = "/api/address/{id}")
    public void deleteAddress(@PathVariable long id) {
        addressService.deleteAddress(id);
    }

    @RequestMapping("/api/address/names/{name}")
    public List<Address> findAllByName(@PathVariable String name) {
        return addressService.findAllByName(name);
    }

}
