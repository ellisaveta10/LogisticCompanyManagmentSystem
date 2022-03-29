package com.example.project.web.view.model;

import com.example.project.data.entity.LogisticsCompany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CourierEmployeeViewModel {
    private long id;
    private String name;
    private LogisticsCompany logisticsCompany;
}
