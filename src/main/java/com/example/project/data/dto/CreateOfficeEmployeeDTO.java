package com.example.project.data.dto;

import com.example.project.data.entity.LogisticsCompany;
import com.example.project.data.entity.Shipment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateOfficeEmployeeDTO {
    private String name;
    private LogisticsCompany logisticsCompany;
    private Set<Shipment> shipments;
}
