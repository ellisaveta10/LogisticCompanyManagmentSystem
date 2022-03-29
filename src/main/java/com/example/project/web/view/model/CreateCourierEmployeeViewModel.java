package com.example.project.web.view.model;


import com.example.project.data.entity.LogisticsCompany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateCourierEmployeeViewModel {
    @NotBlank(message = "Courier name cannot be blank!")
    @Size(min = 2, max = 20, message="Min length: 2, max length: 20")
    @Pattern(regexp = "^([A-Z]).*", message = "Courier name  has to start with capital letter!")
    private String name;

    private LogisticsCompany logisticsCompany;
}
