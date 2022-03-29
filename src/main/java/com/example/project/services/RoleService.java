package com.example.project.services;

import com.example.project.data.dto.CreateRoleDTO;
import com.example.project.data.dto.RoleDTO;
import com.example.project.data.dto.UpdateRoleDTO;
import com.example.project.data.entity.Roles;

import java.util.List;

public interface RoleService {

    List<RoleDTO> getRoles();

    RoleDTO getRole(long id);

    RoleDTO getRoleByName(String name);

    List<RoleDTO> getRolesByName(String name);

    Roles create(CreateRoleDTO createRoleDTO);

    Roles updateRole(long id, UpdateRoleDTO updateRoleDTO);

    void deleteRole(long id);
}
