package com.example.project.web.view.model;

import com.example.project.data.entity.LogisticsCompany;
import com.example.project.data.entity.Office;
import com.example.project.data.entity.OfficeEmployee;
import com.example.project.data.entity.Shipment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateOfficeEmployeeViewModel {
    @NotBlank(message = "Office employee name cannot be blank!")
    @Size(min = 2, max = 20, message="Min length: 2, max length: 20")
    @Pattern(regexp = "^([A-Z]).*", message = "Office employee has to start with capital letter!")
    private String name;

    private LogisticsCompany logisticsCompany;

    private Set<Shipment> shipments;


    //private Office office;
}
