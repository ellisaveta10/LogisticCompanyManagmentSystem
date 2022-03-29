package com.example.project.web.view.controllers;

import com.example.project.data.dto.CreateOfficeDTO;
import com.example.project.data.entity.Office;
import com.example.project.services.AddressService;
import com.example.project.services.LogisticsCompanyService;
import com.example.project.services.OfficeService;
import com.example.project.web.view.model.CreateOfficeViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/offices")
public class OfficeController {

    private final ModelMapper modelMapper;

    private OfficeService officeService;
    private AddressService addressService;
    private LogisticsCompanyService logisticsCompanyService;

    @GetMapping
    public String getOffices(Model model){
        final List<Office> offices = officeService.getOffices();
        model.addAttribute("offices", offices);
        return "/offices/offices.html";
    }

    @GetMapping("/create-office")
    public String showCreateOfficeForm(Model model){
        model.addAttribute("addresses", addressService.getAddresses());
        model.addAttribute("companies", logisticsCompanyService.getLogisticsCompanies());
        // RABOTI model.addAttribute("office", new Office());
        model.addAttribute("office", new CreateOfficeViewModel());

        return "/offices/create-office";
    }

    //RABOTI
//    @PostMapping("/create")
//    public String createOffice(@Valid @ModelAttribute Office office){
//        officeService.create(office);
//        return "redirect:/offices";
//    }


    //DTO TODO:
    @PostMapping("/create")
    public String createOffice(@Valid @ModelAttribute("office") CreateOfficeViewModel office,
                               BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/offices/create-office";
        }
        officeService.create(modelMapper.map(office, CreateOfficeDTO.class));
        return "redirect:/offices";
    }


    @GetMapping("/edit-office/{id}")
    public String showEditOfficeForm(Model model, @PathVariable Long id){
        model.addAttribute("office", officeService.getOffice(id));
        model.addAttribute("addresses", addressService.getAddresses());
        model.addAttribute("companies", logisticsCompanyService.getLogisticsCompanies());
        return "/offices/edit-office";
    }

    @PostMapping("/update/{id}")
    public String updateOffice(Model model, @PathVariable long id, Office office){
        officeService.updateOffice(id, office);
        return "redirect:/offices";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id){
        officeService.deleteOffice(id);
        return "redirect:/offices";
    }
}
