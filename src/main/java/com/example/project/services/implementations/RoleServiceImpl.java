package com.example.project.services.implementations;

import com.example.project.data.dto.CreateRoleDTO;
import com.example.project.data.dto.RoleDTO;
import com.example.project.data.dto.UpdateRoleDTO;
import com.example.project.data.entity.Roles;
import com.example.project.data.repository.RoleRepository;
import com.example.project.services.RoleService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    public List<RoleDTO> getRoles(){
        return roleRepository.findAll().stream().
                map(this::convertToRoleDTO).collect(Collectors.toList());
    }

    @Override
    public RoleDTO getRole(long id) {
        return modelMapper.map(roleRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Invalid role Id:" + id)), RoleDTO.class);
    }

    @Override
    public RoleDTO getRoleByName(String name) {
        return modelMapper.map(name, RoleDTO.class);
    }

    @Override
    public List<RoleDTO> getRolesByName(String name) {
        return roleRepository.findAllByName(name).stream()
                .map(this::convertToRoleDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Roles create(CreateRoleDTO createRoleDTO) {
        return roleRepository.save(modelMapper.map(createRoleDTO, Roles.class));
    }

    @Override
    public Roles updateRole(long id, UpdateRoleDTO updateRoleDTO) {
        Roles role = modelMapper.map(updateRoleDTO, Roles.class);
        role.setId(id);
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(long id) {
        roleRepository.deleteById(id);
    }


    private RoleDTO convertToRoleDTO(Roles role){
        return modelMapper.map(role, RoleDTO.class);
    }

}
