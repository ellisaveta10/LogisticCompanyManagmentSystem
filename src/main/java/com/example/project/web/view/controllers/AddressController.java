package com.example.project.web.view.controllers;

import com.example.project.data.dto.AddressDTO;
import com.example.project.data.dto.CreateAddressDTO;
import com.example.project.data.dto.UpdateAddressDTO;
import com.example.project.services.AddressService;
import com.example.project.web.view.model.AddressViewModel;
import com.example.project.web.view.model.CreateAddressViewModel;
import com.example.project.web.view.model.UpdateAddressViewModel;
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
@RequestMapping("/addresses")
public class AddressController {

    private AddressService addressService;
    private final ModelMapper modelMapper;

    @GetMapping
    public String getAddresses(Model model){
        final List<AddressViewModel> addresses = addressService.getAddresses()
                .stream().map(this::convertToAddressViewModel)
                .collect(Collectors.toList());
        model.addAttribute("addresses", addresses);
        return "/addresses/addresses.html";
    }

    @GetMapping("/create-address")
    public String showCreateAddressForm(Model model){
        model.addAttribute("address", new CreateAddressViewModel());
        return "/addresses/create-address";
    }

    @PostMapping("/create")
    public String createAddress(@Valid @ModelAttribute("address") AddressViewModel address,
                                BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/addresses/create-address";
        }
        addressService.create(modelMapper.map(address, CreateAddressDTO.class));
        return "redirect:/addresses";
    }

    @GetMapping("/edit-address/{id}")
    public String showEditAddressForm(Model model, @PathVariable Long id){
        model.addAttribute("address", modelMapper.map(addressService.getAddress(id),
                UpdateAddressViewModel.class));
        return "/addresses/edit-address";
    }

    @PostMapping("/update/{id}")
    public String updateAddress(@PathVariable long id, @Valid @ModelAttribute("address") UpdateAddressViewModel
                                address, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/addresses/edit-address";
        }
        addressService.updateAddress(id, modelMapper.map(address, UpdateAddressDTO.class));
        return "redirect:/addresses";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id){
        addressService.deleteAddress(id);
        return "redirect:/addresses";
    }

    private AddressViewModel convertToAddressViewModel(AddressDTO addressDTO) {
        return modelMapper.map(addressDTO, AddressViewModel.class);
    }

}
