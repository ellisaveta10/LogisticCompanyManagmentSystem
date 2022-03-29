package com.example.project.web.api;

import com.example.project.data.dto.CreateOfficeDTO;
import com.example.project.data.entity.Office;
import com.example.project.services.OfficeService;
import com.example.project.web.view.model.CreateOfficeViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class OfficeApiController {

    private final OfficeService officeService;
    private final ModelMapper modelMapper;

    //private final ModelMapper modelMapper;
    @GetMapping(value = "/api/office")
    public List<Office> getOffices() {
        return officeService.getOffices();
    }

    @RequestMapping("/api/office/{id}")
    public Office getOffice(@PathVariable("id") int id) {
        return officeService.getOffice(id);
    }

    //RABOTI
//    @PostMapping(value = "/api/office")
//    public Office createOffice(@RequestBody Office office) {
//        return officeService.create(office);
//    }


    //DTO TODO:
    @PostMapping(value = "/api/office")
    public Office createOffice(@RequestBody @Valid CreateOfficeViewModel office) {
        return officeService.create(modelMapper.map(office, CreateOfficeDTO.class));
    }

    //@RequestMapping(method = RequestMethod.POST, value = "/api/logistics_company")
    //public LogisticsCompany createLogisticsCompany(LogisticsCompany logisticsCompany) {
    //return logisticsCompanyService.create(logisticsCompany);
    //}

    @RequestMapping(method = RequestMethod.PUT, value = "/api/office/{id}")
    public Office updateOffice(@PathVariable("id") long id, @RequestBody Office office) {
        return officeService.updateOffice(id, office);
    }

    @DeleteMapping(value = "/api/office/{id}")
    public void deleteOffice(@PathVariable long id) {
        officeService.deleteOffice(id);
    }

//    @RequestMapping("/api/schools/max-students/{maxStudents}")
//    public List<School> getSchoolsByMaxNumberOfStudents(@PathVariable int maxStudents) {
//        return schoolService.getSchoolsByMaxNumberOfStudents(maxStudents);
//    }
//    @RequestMapping("/api/schools/names/{name}")
//    public List<School> getSchoolsByMaxNumberOfStudents(@PathVariable String name) {
//        return schoolService.getSchoolsByName(name);
//    }
//
//    @RequestMapping("/api/schools/names/{name}/max-students/{maxStudents}")
//    public List<School> getSchoolsByMaxNumberOfStudents(@PathVariable String name, @PathVariable int maxStudents) {
//        return schoolService.getSchoolsByNameAndMaxNumberOfStudents(name, maxStudents);
//    }
//
//    @RequestMapping("/api/highschools")
//    public List<School> getHighSchools() {
//        return schoolService.getAllHighSchools();
//    }
//
//    @RequestMapping("/api/schools/{id}/teachers")
//    public List<Teacher> getSchoolTeachers(@PathVariable long id) {
//        return schoolService.getAllTeachersBySchoolId(id);
//    }
//
}
