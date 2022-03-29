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
public class ClientsDTO {
    private long id;
    private String name;
    private Set<LogisticsCompany> logisticsCompanies;
    private int deleted;
}
