package lk.ijse.TLManageSystem.controller;

import lk.ijse.TLManageSystem.dto.TechLeadDTO;
import lk.ijse.TLManageSystem.service.TechLeadService;
import lk.ijse.TLManageSystem.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/techLead")
public class TechLeadController {

    @Autowired
    TechLeadService techLeadService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCustomers(){
        return new ResponseUtil(200,"OK",techLeadService.getAllTechLead());
    }

    @ResponseStatus(HttpStatus.CREATED)//201

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCustomer(@RequestBody TechLeadDTO dto){

        techLeadService.saveTechLead(dto);
        return new ResponseUtil(200,"Save..!",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCustomer(@RequestBody TechLeadDTO dto){
        techLeadService.updateTechLead(dto);
        return new ResponseUtil(200,"Updated..!",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCustomer(@RequestParam String id){
        techLeadService.deleteTechLead(id);
        return new ResponseUtil(200,"Deleted..!",null);
    }

    @GetMapping(path = "/id",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCustomer(@PathVariable String id){
        return new ResponseUtil(200,"OK",techLeadService.searchTechLead(id));
    }

}
