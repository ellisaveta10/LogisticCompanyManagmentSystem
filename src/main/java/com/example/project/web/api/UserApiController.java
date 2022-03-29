package com.example.project.web.api;

import com.example.project.data.dto.*;
import com.example.project.data.entity.Shipment;
import com.example.project.data.entity.User;
import com.example.project.services.implementations.UserServiceImpl;
import com.example.project.web.view.model.CreateShipmentViewModel;
import com.example.project.web.view.model.CreateUserViewModel;
import com.example.project.web.view.model.UpdateShipmentViewModel;
import com.example.project.web.view.model.UpdateUserViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserApiController {
    private final UserServiceImpl service;
    private final ModelMapper modelMapper;

    @GetMapping(value = "/api/user")
    public List<UserDTO> getUsers() {
        return service.listAll();
    }

    @RequestMapping("/api/user/{id}")
    public UserDTO getUser(@PathVariable("id") int id) {
        return service.get(id);
    }

    @PostMapping(value = "/api/user")
    public User createUser(@RequestBody CreateUserViewModel user) {
        return service.create(modelMapper.map(user, CreateUserDTO.class));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/api/user/{id}")
    public User updateUser(@PathVariable("id") long id, @RequestBody UpdateUserViewModel user) {
        return service.updateUser(id, modelMapper.map(user, UpdateUserDTO.class));
    }

    @DeleteMapping(value = "/api/user/{id}")
    public void deleteUser(@PathVariable long id) {
        service.deleteUser(id);
    }
}
