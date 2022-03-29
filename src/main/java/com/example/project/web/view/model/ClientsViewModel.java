package com.example.project.web.view.model;

import com.example.project.data.entity.LogisticsCompany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ClientsViewModel {
    private long id;
    private String name;
    private Set<LogisticsCompany> logisticsCompanies;
}
