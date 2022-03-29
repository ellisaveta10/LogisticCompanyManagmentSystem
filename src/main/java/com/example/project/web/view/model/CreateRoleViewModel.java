package com.example.project.web.view.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class CreateRoleViewModel {
    @NotNull
    private String name;
}
