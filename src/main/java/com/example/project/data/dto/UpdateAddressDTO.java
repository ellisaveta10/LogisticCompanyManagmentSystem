package com.example.project.data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateAddressDTO {
    private String address;
    private int deleted;
}
