package com.example.project.services.implementations;

import com.example.project.data.dto.AddressDTO;
import com.example.project.data.dto.CreateAddressDTO;
import com.example.project.data.dto.UpdateAddressDTO;
import com.example.project.data.entity.Address;
import com.example.project.data.repository.AddressRepository;
import com.example.project.services.AddressService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<AddressDTO> getAddresses() {
        return addressRepository.findAll().stream()
                .map(this::convertToAddressDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AddressDTO getAddress(long id) {
        return modelMapper.map(addressRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Address ID: " + id)), AddressDTO.class);
    }

    @Override
    public Address create(CreateAddressDTO createAddressDTO) {
        return addressRepository.save(modelMapper.map(createAddressDTO, Address.class));
    }

    @Override
    public Address updateAddress(long id, UpdateAddressDTO updateAddressDTO) {
        Address address1 = modelMapper.map(updateAddressDTO, Address.class);
        address1.setId(id);
        return addressRepository.save(address1);
    }

    @Override
    public void deleteAddress(long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public List<Address> findAllByName(String name){
        return addressRepository.findAllByAddress(name);
    }



    private AddressDTO convertToAddressDTO(Address address) {
        return modelMapper.map(address, AddressDTO.class);
    }
}
