package com.example.project.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="shipment")

public class Shipment extends BaseEntity {
    private long id;

    @OneToOne
    @JoinColumn(name="sender")
    private Clients sender;

    @OneToOne
    @JoinColumn(name="receiver")
    private Clients receiver;

    @OneToOne
    @JoinColumn(name="address_for_sending")
    private Address address;

    @JoinColumn(name="weight")
    private double weight;

    @ManyToOne
    @JoinColumn(name="office_employee_id")
    private OfficeEmployee officeEmployee;

    @ManyToOne
    @JoinColumn(name="logisticsCompany_id")
    private LogisticsCompany logisticsCompany;
}
