package com.example.project.web.view.model;

import com.example.project.data.entity.Address;
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
public class UpdateOfficeViewModel {

    @NotBlank(message = "Address name cannot be blank!")
    @Size(min = 2, max = 20, message="Min length: 2, max length: 20")
    @Pattern(regexp = "^([A-Z]).*", message = "Address has to start with capital letter!")
    private Address address;

   // private LogisticsCompany logisticsCompany;

    private LogisticsCompany logisticsCompany;
}
