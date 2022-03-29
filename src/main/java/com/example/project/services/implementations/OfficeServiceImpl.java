package com.example.project.services.implementations;

import com.example.project.data.dto.CreateOfficeDTO;
import com.example.project.data.entity.Office;
import com.example.project.data.repository.OfficeRepository;
import com.example.project.services.OfficeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
@AllArgsConstructor
public class OfficeServiceImpl implements OfficeService {

    private final OfficeRepository officeRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Office> getOffices() {
        return officeRepository.findAll();
    }

    @Override
    public Office getOffice(long id) {
        return officeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Office ID: " + id));
    }

    //RABOTI
//    @Override
//    public Office create(Office office) {
//        return officeRepository.save(office);
//    }

    //DTO TODO:
    @Override
    public Office create(@Valid CreateOfficeDTO createOfficeDTO) {
        return officeRepository.save(modelMapper.map(createOfficeDTO, Office.class));
    }


    @Override
    public Office updateOffice(long id, Office office) {
        office.setId(id);
        return officeRepository.save(office);
    }

    @Override
    public void deleteOffice(long id) {
        officeRepository.deleteById(id);
    }
}
