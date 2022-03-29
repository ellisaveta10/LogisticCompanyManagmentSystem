package com.example.project.web.api;

import com.example.project.data.dto.CreateOfficeEmployeeDTO;
import com.example.project.data.dto.OfficeEmployeeDTO;
import com.example.project.data.dto.UpdateOfficeEmployeeDTO;
import com.example.project.data.entity.OfficeEmployee;
import com.example.project.services.OfficeEmployeeService;
import com.example.project.web.view.model.CreateOfficeEmployeeViewModel;
import com.example.project.web.view.model.UpdateCourierEmployeeViewModel;
import com.example.project.web.view.model.UpdateOfficeEmployeeViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class OfficeEmployeeApiController {

    private final OfficeEmployeeService officeEmployeeService;
    private final ModelMapper modelMapper;

    //private final ModelMapper modelMapper;
    @GetMapping(value = "/api/office_employee")
    public List<OfficeEmployeeDTO> getOfficeEmployees() {
        return officeEmployeeService.getOfficeEmployees();
    }

    @RequestMapping("/api/office_employee/{id}")
    public OfficeEmployeeDTO getOfficeEmployee(@PathVariable("id") int id) {
        return officeEmployeeService.getOfficeEmployee(id);
    }

    @PostMapping(value = "/api/office_employee")
    public OfficeEmployee createOfficeEmployee(@RequestBody CreateOfficeEmployeeViewModel officeEmployee) {
        return officeEmployeeService.create(modelMapper.map(officeEmployee, CreateOfficeEmployeeDTO.class));
    }

    //@RequestMapping(method = RequestMethod.POST, value = "/api/logistics_company")
    //public LogisticsCompany createLogisticsCompany(LogisticsCompany logisticsCompany) {
    //return logisticsCompanyService.create(logisticsCompany);
    //}

    @RequestMapping(method = RequestMethod.PUT, value = "/api/office_employee/{id}")
    public OfficeEmployee updateOfficeEmployee(@PathVariable("id") long id, @RequestBody UpdateOfficeEmployeeViewModel officeEmployee) {
        return officeEmployeeService.updateOfficeEmployee(id, modelMapper.map(officeEmployee, UpdateOfficeEmployeeDTO.class));
    }

    @DeleteMapping(value = "/api/office_employee/{id}")
    public void deleteOfficeEmployee(@PathVariable long id) {
        officeEmployeeService.deleteOfficeEmployee(id);
    }

}