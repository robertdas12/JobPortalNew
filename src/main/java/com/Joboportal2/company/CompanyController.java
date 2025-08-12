package com.Joboportal2.company;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {


    private  CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }



    @GetMapping()
     public List<Company> getAllCompanies(){
         return this.companyService.getAllCompanies();
     }


     @PutMapping("/update/{id}")
     public ResponseEntity<Company> updateCompany(@PathVariable int id, @RequestBody Company company){
         System.out.println("id is >>>>>>>>>>" + id);
          Company updatedCompany = this.companyService.updateCompany(id,company);
         System.out.println("updatedCompany>>>>>>" + updatedCompany );
          if (updatedCompany!=null){
               return  new ResponseEntity<Company>(updatedCompany, HttpStatus.OK);
          }
          else {
               return  new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
          }
     }

     @PostMapping("/create")
     public ResponseEntity<Company> createCompnay(@RequestBody Company company){
          Company createdCompany =  this.companyService.createCompany(company);
          if(createdCompany!=null){
               return  new ResponseEntity<>(createdCompany,HttpStatus.CREATED);
          }
          else {
               return  new ResponseEntity<>(HttpStatus.FORBIDDEN);
          }

     }


     @DeleteMapping("/{id}")
     public  ResponseEntity<String> deleteCompany(@PathVariable int id){
         Boolean result =    this.companyService.deleteCompany(id);
         if(result){
              return  new ResponseEntity<>("company Deleted successfully",HttpStatus.OK);
         }
         else {
             return  new ResponseEntity<>("company not found",HttpStatus.NOT_FOUND);
         }
     }


     @GetMapping("/findById/{id}")
     public  ResponseEntity<Company> getCompanyById(@PathVariable int id){
         Company company =   this.companyService.getCompanyById(id);
         if(company!=null){
              return  new ResponseEntity<>(company,HttpStatus.OK);
         }
         else {
              return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
     }
}
