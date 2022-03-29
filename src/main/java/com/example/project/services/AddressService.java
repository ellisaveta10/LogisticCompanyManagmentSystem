package com.example.project.services;

import com.example.project.data.dto.AddressDTO;
import com.example.project.data.dto.CreateAddressDTO;
import com.example.project.data.dto.UpdateAddressDTO;
import com.example.project.data.entity.Address;
import java.util.List;

public interface AddressService {

    List<AddressDTO> getAddresses();

    AddressDTO getAddress(long id);

    Address create(CreateAddressDTO createAddressDTO);

    Address updateAddress(long id, UpdateAddressDTO updateAddressDTO);

    void deleteAddress(long id);

    List<Address>findAllByName(String name);
}
