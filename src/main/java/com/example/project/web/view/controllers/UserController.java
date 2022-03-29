package com.example.project.web.view.controllers;

import com.example.project.data.dto.*;
import com.example.project.data.entity.User;
import com.example.project.data.repository.UserRepository;
import com.example.project.services.implementations.UserServiceImpl;
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
@RequestMapping("/users")
public class UserController {
    private final ModelMapper modelMapper;
    private UserServiceImpl service;
    private UserRepository userRepository;

    /*@GetMapping
    public String getUsers(Model model){
        final List<UserViewModel> users = service.listAll()
                .stream().map(this::convertToUserViewModel)
                .collect(Collectors.toList());
        model.addAttribute("users", users);
        return "/users/users.html";
    }*/

    @GetMapping("/create-user")
    public String showCreateUserForm(Model model){
        model.addAttribute("user", new CreateUserViewModel());
        return "/users/create-user";
    }

    @PostMapping("/create")
    public String createUser(@Valid @ModelAttribute("user") CreateUserViewModel user,
                                 BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "users/create-user";
        }
        service.create(modelMapper.map(user, CreateUserDTO.class));
        return "redirect:/users";
    }

    /*@GetMapping("/edit-user/{id}")
    public String showEditUserForm(Model model, @PathVariable Long id){
        model.addAttribute("user", modelMapper.map(service.get(id),
                UpdateUserViewModel.class));
        return "/users/edit-user";
    }*/

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable long id, @Valid @ModelAttribute("user") UpdateUserViewModel user,
                                 BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "users/edit-user";
        }
        service.updateUser(id, modelMapper.map(user, UpdateUserDTO.class));
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id){
        service.deleteUser(id);
        return "redirect:/users";
    }

    private UserViewModel convertToUserViewModel(UserDTO userDTO) {
        return modelMapper.map(userDTO, UserViewModel.class);
    }

    /*@GetMapping("/edit-user/{id}")
    public String editUser(@PathVariable("id") long id, Model model) {
        //User user = service.get(id);
        UserDTO user = service.get(id);
        //List<Roles> listRoles = service.listRoles();
        List<RoleDTO> listRoles = service.listRoles();
        model.addAttribute("user", user);
        model.addAttribute("listRoles", listRoles);
        return "users";
    }*/

    @PostMapping("/save")
    public String saveUser(User user) {
        service.save(user);
        return "redirect:/users";
    }




}
