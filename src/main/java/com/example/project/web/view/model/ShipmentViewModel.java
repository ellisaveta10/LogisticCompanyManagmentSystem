package com.example.project.web.view.model;

import com.example.project.data.entity.Address;
import com.example.project.data.entity.Clients;
import com.example.project.data.entity.OfficeEmployee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ShipmentViewModel {
    private long id;
    private Clients sender;
    private Clients receiver;
    private Address address;
    private OfficeEmployee officeEmployee;
    private double weight;
}
