package com.example.project.web.view.model;

import com.example.project.data.entity.Roles;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateUserViewModel {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Set<Roles> roles;
}
