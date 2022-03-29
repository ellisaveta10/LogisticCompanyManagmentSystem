package com.example.project.web.view.model;

import com.example.project.data.entity.LogisticsCompany;
import com.example.project.data.entity.Shipment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class OfficeEmployeeViewModel {
    private long id;
    private String name;
    private LogisticsCompany logisticsCompany;
    private Set<Shipment> shipments;
}