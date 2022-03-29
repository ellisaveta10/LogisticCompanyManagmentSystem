package com.example.project.data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateRoleDTO {
    private String name;
    private int deleted;
}
