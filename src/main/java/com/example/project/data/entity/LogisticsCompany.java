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
@Table(name = "logisticsCompany")
@Entity
public class LogisticsCompany extends BaseEntity{
    private String name;

    /*@OneToMany(mappedBy="logisticsCompany")
    @JsonIgnoreProperties("logisticsCompany")
    private Set<Office> offices;*/

    /*@OneToMany(mappedBy="logisticsCompany")
    @JsonIgnoreProperties("logisticsCompany")
    private Set<OfficeEmployee> officeEmployees;

    @OneToMany(mappedBy="logisticsCompany")
    @JsonIgnoreProperties("logisticsCompany")
    private Set<CourierEmployee> courierEmployees;*/

    /*@JoinTable(
            name = "logistics_companies_clients",
            joinColumns = @JoinColumn(name = "logistics_company_id"),
            inverseJoinColumns = @JoinColumn(name = "clients_id")
    )*/
//    @ManyToMany
//    private Set<Clients> clients;

    /*public void addClient(Clients clients) {
        this.clients.add(clients);
    }*/
}
