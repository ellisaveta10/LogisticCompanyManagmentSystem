package com.example.project.data.dto;

import com.example.project.data.entity.Roles;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateUserDTO {
    private long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Set<Roles> roles;
    private int deleted;
}
