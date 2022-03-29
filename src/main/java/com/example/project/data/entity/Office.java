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
@Table(name="office")
public class Office extends BaseEntity{

    private String name;
    @OneToOne
    private Address address;

    /*@OneToMany
    @JsonIgnoreProperties("office")
    private Set<OfficeEmployee> officeEmployees;*/

    @ManyToOne
    @JoinColumn(name="logisticsCompany_id")
    private LogisticsCompany logisticsCompany;
}
