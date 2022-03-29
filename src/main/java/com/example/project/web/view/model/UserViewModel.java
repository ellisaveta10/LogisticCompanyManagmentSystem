package com.example.project.web.view.model;

import com.example.project.data.entity.Roles;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserViewModel {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Set<Roles> roles;
}
