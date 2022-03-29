package com.example.project.data.dto;

import com.example.project.data.entity.LogisticsCompany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateClientsDTO {
    private String name;
    private Set<LogisticsCompany> logisticsCompanies;
}
