package com.example.project.web.view.model;

import com.example.project.data.entity.Clients;
import com.example.project.data.entity.CourierEmployee;
import com.example.project.data.entity.Office;
import com.example.project.data.entity.OfficeEmployee;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateLogisticCompanyViewModel {

    @NotBlank(message = "Logistic company name cannot be blank!")
    @Size(min = 2, max = 20, message="Min length: 2, max length: 20")
    @Pattern(regexp = "^([A-Z]).*", message = "Logistic company  has to start with capital letter!")
    private String name;

    /*private Set<Office> offices;

    private Set<OfficeEmployee> officeEmployees;

    private Set<CourierEmployee> courierEmployees;*/

    private Set<Clients> clients;

}
