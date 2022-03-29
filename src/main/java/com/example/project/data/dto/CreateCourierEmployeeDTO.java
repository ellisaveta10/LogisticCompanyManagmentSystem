package com.example.project.data.dto;

import com.example.project.data.entity.LogisticsCompany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateCourierEmployeeDTO {
    private String name;
    private LogisticsCompany logisticsCompany;
}
