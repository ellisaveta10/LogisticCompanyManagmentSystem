package com.example.project.web.view.model;

import com.example.project.data.entity.Clients;
import com.example.project.data.entity.CourierEmployee;
import com.example.project.data.entity.Office;
import com.example.project.data.entity.OfficeEmployee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class LogisticCompanyViewModel {
    private long id;
    private String name;
    private Set<Office> offices;
    //private Set<OfficeEmployee> officeEmployees;
    //private Set<CourierEmployee> courierEmployees;
    private Set<Clients> clients;
}
