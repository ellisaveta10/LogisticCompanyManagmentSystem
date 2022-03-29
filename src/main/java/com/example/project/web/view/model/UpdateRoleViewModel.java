package com.example.project.web.view.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateRoleViewModel {
    @NotNull
    private String name;
}
