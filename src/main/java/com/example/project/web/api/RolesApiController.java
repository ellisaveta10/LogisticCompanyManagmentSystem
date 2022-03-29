package com.example.project.web.api;

import com.example.project.data.dto.*;
import com.example.project.data.entity.Roles;
import com.example.project.services.RoleService;
import com.example.project.web.view.model.CreateRoleViewModel;
import com.example.project.web.view.model.RoleViewModel;
import com.example.project.web.view.model.UpdateRoleViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class RolesApiController {
    private final RoleService roleService;
    private final ModelMapper modelMapper;

    @GetMapping(value = "/api/role")
    public List<RoleDTO> getRole() {
        return roleService.getRoles();
    }

    @RequestMapping("/api/role/{id}")
    public RoleDTO getRole(@PathVariable("id") int id) {
        return roleService.getRole(id);
    }

    @PostMapping(value = "/api/role")
    public Roles createRole(@RequestBody CreateRoleViewModel role) {
        return roleService.create(modelMapper.map(role, CreateRoleDTO.class));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/api/role/{id}")
    public Roles updateRoles(@PathVariable("id") long id, @RequestBody UpdateRoleViewModel role) {
        return roleService.updateRole(id, modelMapper.map(role, UpdateRoleDTO.class));
    }

    @DeleteMapping(value = "/api/role/{id}")
    public void deleteRole(@PathVariable long id) {
        roleService.deleteRole(id);
    }
    
}
