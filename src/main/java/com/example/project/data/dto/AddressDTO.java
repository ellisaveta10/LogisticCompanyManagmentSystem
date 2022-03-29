package com.example.project.data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressDTO {
    private long id;
    private String address;
    private int deleted;
}
