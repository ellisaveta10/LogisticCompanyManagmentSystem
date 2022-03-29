package com.example.project.data.dto;

import com.example.project.data.entity.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateShipmentDTO {
    private Clients sender;
    private Clients receiver;
    private Address address;
    private double weight;
    private OfficeEmployee officeEmployee;
    private LogisticsCompany logisticsCompany;
    private int deleted;
}
