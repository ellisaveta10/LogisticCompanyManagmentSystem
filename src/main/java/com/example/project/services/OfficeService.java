package com.example.project.services;

import com.example.project.data.dto.CreateOfficeDTO;
import com.example.project.data.entity.Office;

import javax.validation.Valid;
import java.util.List;

public interface OfficeService {

    List<Office> getOffices();

    Office getOffice(long id);

    //RABOTI
//    Office create(Office office);

    //DTO TODO:
    Office create(@Valid CreateOfficeDTO createOfficeDTO);

    Office updateOffice(long id, Office office);

    void deleteOffice(long id);
}
