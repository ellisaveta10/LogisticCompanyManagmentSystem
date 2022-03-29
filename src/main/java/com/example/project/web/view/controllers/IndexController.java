package com.example.project.web.view.controllers;

import com.example.project.data.dto.RoleDTO;
import com.example.project.data.dto.UserDTO;
import com.example.project.data.entity.Roles;
import com.example.project.data.entity.User;
import com.example.project.data.repository.RoleRepository;
import com.example.project.data.repository.UserRepository;
import com.example.project.services.implementations.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class IndexController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl service;

    @Autowired RoleRepository roleRepo;

    /*@GetMapping("")
    public String viewHomePage(){
        return "index";
    }*/

    @GetMapping
    public String getIndex(Model model) {
        final String welcomeMessage="Welcome to the Logistics Company Management System!";
        model.addAttribute("welcome", welcomeMessage);
        return "index";
    }


    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        List<Roles> listRoles = service.listRoles();
        model.addAttribute("listRoles", listRoles);
        return "registration";
    }

    @PostMapping("/process_register")
    public String processRegister(User user, Model model) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        for(User u: userRepository.findAll()){
            if(u.getEmail().equals(user.getEmail())) {
                return "register_failure";
            }
        }
        userRepository.save(user);
        return "register_success";
    }


    @GetMapping("/users")
    public String listUsers(Model model) {
        /**List<User> userList = service.listAll();*/
        List<UserDTO> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }

        @GetMapping("users/edit-user/{id}")
        public String editUser(@PathVariable("id") long id, Model model) {
        UserDTO user = service.get(id);
        List<Roles> listRoles = service.listRoles();
        model.addAttribute("user", user);
        model.addAttribute("listRoles", listRoles);
        return "edit-user";
        }

}
