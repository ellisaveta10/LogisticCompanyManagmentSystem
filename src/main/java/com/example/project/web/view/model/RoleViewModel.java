package com.example.project.web.view.model;

import com.example.project.data.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RoleViewModel {
    private long id;
    private String name;
    private Set<User> userSet;
}
