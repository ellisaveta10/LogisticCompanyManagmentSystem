package com.example.project.services.implementations;

import com.example.project.data.dto.*;
import com.example.project.data.entity.Roles;
import com.example.project.data.entity.Shipment;
import com.example.project.data.entity.User;
import com.example.project.data.repository.RoleRepository;
import com.example.project.data.repository.ShipmentRepository;
import com.example.project.data.repository.UserRepository;
import com.example.project.services.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    //@Autowired
    private final UserRepository userRepo;

    //@Autowired
    private final RoleRepository roleRepo;

    //@Autowired
    PasswordEncoder passwordEncoder;

    public void registerDefaultUser(User user) {
        Roles roleUser = roleRepo.findByName("Courier Employee");
        user.addRole(roleUser);
        userRepo.save(user);
    }

    public List<UserDTO> listAll() {
        return userRepo.findAll()
                .stream().map(this::convertToUserDTO)
                .collect(Collectors.toList());
    }

    public UserDTO get(long id) {
        return modelMapper.map(userRepo.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Invalid User ID: " + id)), UserDTO.class);
    }

    public void save(User user) {
        userRepo.save(user);
    }

    public List<Roles> listRoles() {
        return roleRepo.findAll();
    }

    @Override
    public User create(CreateUserDTO createUserDTO) {
        return userRepo.save(modelMapper.map(createUserDTO, User.class));
    }

    @Override
    public User updateUser(long id, UpdateUserDTO updateUserDTO) {
        User user = modelMapper.map(updateUserDTO, User.class);
        user.setId(id);
        return userRepo.save(user);
    }

    @Override
    public void deleteUser(long id) {
        userRepo.deleteById(id);
    }

    private UserDTO convertToUserDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    private RoleDTO convertToRoleDTO(Roles role) {
        return modelMapper.map(role, RoleDTO.class);
    }
}
