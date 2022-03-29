package com.example.project.data.entity;

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
@Table(name="clients")
public class Clients extends BaseEntity{
    private String name;

    @ManyToMany
    @JoinTable(
            name = "logistics_companies_clients",
            joinColumns = @JoinColumn(name = "clients_id"),
            inverseJoinColumns = @JoinColumn(name = "logistics_company_id")
    )
    private Set<LogisticsCompany> logisticsCompanies;

    /*public void addClient(Clients clients) {
        this.clients.add(clients);
    }*/
}
