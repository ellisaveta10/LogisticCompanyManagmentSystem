package com.example.project.web.api;

import com.example.project.data.dto.CreateLogisticsCompanyDTO;
import com.example.project.data.dto.LogisticsCompanyDTO;
import com.example.project.data.dto.UpdateLogisticsCompanyDTO;
import com.example.project.data.entity.LogisticsCompany;
import com.example.project.services.LogisticsCompanyService;
import com.example.project.web.view.model.CreateLogisticCompanyViewModel;
import com.example.project.web.view.model.UpdateLogisticCompanyViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import org.modelmapper.ModelMapper;

@RestController
//@RequestMapping("/api/logistics_company")
@AllArgsConstructor
public class LogisticCompanyApiController {

    private final LogisticsCompanyService logisticsCompanyService;
    private final ModelMapper modelMapper;

    //private final ModelMapper modelMapper;
    @GetMapping(value = "/api/logistics_company")
    public List<LogisticsCompanyDTO> getLogisticCompanies() {
        return logisticsCompanyService.getLogisticsCompanies();
    }

    @RequestMapping("/api/logistics_company/{id}")
    public LogisticsCompanyDTO getLogisticsCompany(@PathVariable("id") int id) {
       return logisticsCompanyService.getLogisticCompany(id);
    }

    @PostMapping(value = "/api/logistics_company")
    public LogisticsCompany createLogisticsCompany(@RequestBody CreateLogisticCompanyViewModel logisticsCompany) {
       return logisticsCompanyService.create(modelMapper.map(logisticsCompany, CreateLogisticsCompanyDTO.class));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/api/logistics_company/{id}")
    public LogisticsCompany updateLogisticsCompany(@PathVariable("id") long id, @RequestBody UpdateLogisticCompanyViewModel logisticsCompany) {
        return logisticsCompanyService.updateLogisticCompany(id, modelMapper.map(logisticsCompany, UpdateLogisticsCompanyDTO.class));
    }

    @DeleteMapping(value = "/api/logistics_company/{id}")
    public void deleteLogisticsCompany(@PathVariable long id) {
        logisticsCompanyService.deleteLogisticCompany(id);
    }


}
