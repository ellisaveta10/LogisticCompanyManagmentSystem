package com.example.project.web.api;

import com.example.project.data.dto.*;
import com.example.project.data.entity.CourierEmployee;
import com.example.project.services.CourierEmployeeService;
import com.example.project.web.view.model.CreateCourierEmployeeViewModel;
import com.example.project.web.view.model.UpdateCourierEmployeeViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CourierEmployeeApiController {

    private final CourierEmployeeService courierEmployeeService;
    private final ModelMapper modelMapper;

    //private final ModelMapper modelMapper;
    @GetMapping(value = "/api/courier_employee")
    public List<CourierEmployeeDTO> getCourierEmployees() {
        return courierEmployeeService.getCourierEmployees();
    }

    @RequestMapping("/api/courier_employee/{id}")
    public CourierEmployeeDTO getCourierEmployee(@PathVariable("id") int id) {
        return courierEmployeeService.getCourierEmployee(id);
    }

    @PostMapping(value = "/api/courier_employee")
    public CourierEmployee createCourierEmployee(@RequestBody CreateCourierEmployeeViewModel courierEmployee) {
        return courierEmployeeService.create(modelMapper.map(courierEmployee, CreateCourierEmployeeDTO.class));
    }

    //@RequestMapping(method = RequestMethod.POST, value = "/api/logistics_company")
    //public LogisticsCompany createLogisticsCompany(LogisticsCompany logisticsCompany) {
    //return logisticsCompanyService.create(logisticsCompany);
    //}

    @RequestMapping(method = RequestMethod.PUT, value = "/api/courier_employee/{id}")
    public CourierEmployee updateCourierEmployee(@PathVariable("id") long id, @RequestBody UpdateCourierEmployeeViewModel courierEmployee) {
        return courierEmployeeService.updateCourierEmployee(id, modelMapper.map(courierEmployee, UpdateCourierEmployeeDTO.class));
    }

    @DeleteMapping(value = "/api/courier_employee/{id}")
    public void deleteCourierEmployee(@PathVariable long id) {
        courierEmployeeService.deleteCourierEmployee(id);
    }

//    @RequestMapping("/api/courier_employee/names/{name}")
//    public List<CourierEmployee> findAllByName(@PathVariable String name) {
//        return courierEmployeeService.findAllByName(name);
//    }

}
