package com.example.project.web.view.controllers;

import com.example.project.data.dto.CourierEmployeeDTO;
import com.example.project.data.dto.CreateCourierEmployeeDTO;
import com.example.project.data.dto.LogisticsCompanyDTO;
import com.example.project.data.dto.UpdateCourierEmployeeDTO;
import com.example.project.data.entity.Address;
import com.example.project.data.entity.CourierEmployee;
import com.example.project.services.CourierEmployeeService;
import com.example.project.services.LogisticsCompanyService;
import com.example.project.web.view.model.CourierEmployeeViewModel;
import com.example.project.web.view.model.CreateCourierEmployeeViewModel;
import com.example.project.web.view.model.LogisticCompanyViewModel;
import com.example.project.web.view.model.UpdateCourierEmployeeViewModel;
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
@RequestMapping("/courierEmployees")
public class CourierController {

    private CourierEmployeeService courierEmployeeService;
    private LogisticsCompanyService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public String getCourierEmployees(Model model){
        final List<CourierEmployeeViewModel> courierEmployees = courierEmployeeService.getCourierEmployees()
                .stream().map(this::convertToCourierEmployeeViewModel)
                .collect(Collectors.toList());
        model.addAttribute("courierEmployees", courierEmployees);
        return "/courierEmployees/courierEmployees.html";
    }

    @GetMapping("/create-courierEmployee")
    public String showCreateCourierEmployeeForm(Model model){
        model.addAttribute("courierEmployee", new CreateCourierEmployeeViewModel());
        List<LogisticsCompanyDTO> logisticsCompanies = service.getLogisticsCompanies();
        model.addAttribute("logisticsCompanies", logisticsCompanies);
        return "/courierEmployees/create-courierEmployee";
    }

    @PostMapping("/create")
    public String createCourierEmployee(@Valid @ModelAttribute("courierEmployee")
                                                CreateCourierEmployeeViewModel courierEmployee,
                                        BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "courierEmployees/create-courierEmployee";
        }
        List<LogisticsCompanyDTO> logisticsCompanies = service.getLogisticsCompanies();
        model.addAttribute("logisticsCompanies", logisticsCompanies);
        courierEmployeeService.create(modelMapper.map(courierEmployee, CreateCourierEmployeeDTO.class));
        return "redirect:/courierEmployees";
    }

    @GetMapping("/edit-courierEmployee/{id}")
    public String showEditCourierEmployeeForm(Model model, @PathVariable Long id){
        model.addAttribute("courierEmployee", modelMapper.map(courierEmployeeService.getCourierEmployee(id),
                UpdateCourierEmployeeViewModel.class));
        List<LogisticsCompanyDTO> logisticsCompanies = service.getLogisticsCompanies();
        model.addAttribute("logisticsCompanies", logisticsCompanies);
        return "/courierEmployees/edit-courierEmployee";
    }

    @PostMapping("/update/{id}")
    public String updateCourierEmployee(@PathVariable long id, @Valid @ModelAttribute("courierEmployee")
            UpdateCourierEmployeeViewModel courierEmployee, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "courierEmployees/edit-courierEmployee";
        }
        courierEmployeeService.updateCourierEmployee(id, modelMapper.map(courierEmployee, UpdateCourierEmployeeDTO.class));
        List<LogisticsCompanyDTO> logisticsCompanies = service.getLogisticsCompanies();
        model.addAttribute("logisticsCompanies", logisticsCompanies);
        return "redirect:/courierEmployees";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id){
        courierEmployeeService.deleteCourierEmployee(id);
        return "redirect:/courierEmployees";
    }

    private CourierEmployeeViewModel convertToCourierEmployeeViewModel(CourierEmployeeDTO courierEmployeeDTO) {
        return modelMapper.map(courierEmployeeDTO, CourierEmployeeViewModel.class);
    }
}
