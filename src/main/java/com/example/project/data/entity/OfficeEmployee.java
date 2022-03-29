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
@Table(name="officeEmployee")
public class OfficeEmployee extends BaseEntity{
    private String name;

    @ManyToOne
    @JoinColumn(name="logisticsCompany_id")
    private LogisticsCompany logisticsCompany;

    /*@OneToMany(mappedBy="officeEmployee")
    @JsonIgnoreProperties("officeEmployee")
    private Set<Shipment> shipments;*/

    /*@ManyToOne
    @JoinColumn(name="office_id")
    private LogisticsCompany Office;*/
}
