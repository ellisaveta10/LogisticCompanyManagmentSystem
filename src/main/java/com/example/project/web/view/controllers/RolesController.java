package com.example.project.web.view.controllers;

import com.example.project.data.dto.*;
import com.example.project.services.RoleService;
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
@RequestMapping("/roles")
public class RolesController {
    private RoleService roleService;
    private final ModelMapper modelMapper;

    @GetMapping
    public String getRoles(Model model){
        final List<RoleViewModel> roles = roleService.getRoles()
                .stream().map(this::convertToRoleViewModel)
                .collect(Collectors.toList());
        model.addAttribute("roles", roles);
        return "/roles/roles.html";
    }

    @GetMapping("/create-role")
    public String showCreateRoleForm(Model model){
        model.addAttribute("role", new CreateRoleViewModel());
        return "/roles/create-role";
    }

    @PostMapping("/create")
    public String createRole(@Valid @ModelAttribute("role") CreateRoleViewModel role,
                                 BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "roles/create-role";
        }
        roleService.create(modelMapper.map(role, CreateRoleDTO.class));
        return "redirect:/roles";
    }

    @GetMapping("/edit-role/{id}")
    public String showEditRoleForm(Model model, @PathVariable Long id){
        model.addAttribute("role", modelMapper.map(roleService.getRole(id),
                UpdateRoleViewModel.class));
        return "/roles/edit-role";
    }

    @PostMapping("/update/{id}")
    public String updateRole(@PathVariable long id, @Valid @ModelAttribute("role") UpdateRoleViewModel role,
                                 BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "roles/edit-role";
        }
        roleService.updateRole(id, modelMapper.map(role, UpdateRoleDTO.class));
        return "redirect:/roles";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id){
        roleService.deleteRole(id);
        return "redirect:/roles";
    }

    private RoleViewModel convertToRoleViewModel(RoleDTO roleDTO) {
        return modelMapper.map(roleDTO, RoleViewModel.class);
    }
}
