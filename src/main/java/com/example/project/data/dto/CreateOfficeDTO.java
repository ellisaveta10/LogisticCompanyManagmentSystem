package com.example.project.data.dto;

import com.example.project.data.entity.Address;
import com.example.project.data.entity.LogisticsCompany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateOfficeDTO {

    @NotBlank
    @Size(min = 5, max = 20, message="Min 5, Max 25")
    private String name;

    private Address address;

    private LogisticsCompany logisticsCompany;



}
