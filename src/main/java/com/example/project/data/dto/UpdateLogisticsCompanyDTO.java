package com.example.project.data.dto;

import com.example.project.data.entity.Clients;
import com.example.project.data.entity.CourierEmployee;
import com.example.project.data.entity.Office;
import com.example.project.data.entity.OfficeEmployee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateLogisticsCompanyDTO {
    private String name;
    //private Set<Office> offices;
    //private Set<OfficeEmployee> officeEmployees;
    //private Set<CourierEmployee> courierEmployees;
    //private Set<Clients> clients;
    private int deleted;
}
