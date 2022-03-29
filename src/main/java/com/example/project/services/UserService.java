package com.example.project.services;

import com.example.project.data.dto.*;
import com.example.project.data.entity.Roles;
import com.example.project.data.entity.Shipment;
import com.example.project.data.entity.User;

import java.util.List;

public interface UserService {
    /** get all users*/
    List<UserDTO> listAll();

    UserDTO get(long id);

    void save(User user);

    User create(CreateUserDTO createUserDTO);

    User updateUser(long id, UpdateUserDTO updateUserDTO);

    void deleteUser(long id);

    //List<RoleDTO> listRoles();
    List<Roles> listRoles();
}
