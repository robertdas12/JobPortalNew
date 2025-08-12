package com.Joboportal2.company.impl;


import com.Joboportal2.company.Company;
import com.Joboportal2.company.CompanyRepository;
import com.Joboportal2.company.CompanyService;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CompanyServiceImpl implements CompanyService {

     CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }




    @Override
    public List<Company> getAllCompanies() {
        return this.companyRepository.findAll();
    }

    @Override
    public Company updateCompany(int id, Company company) {
        Company company1 =  this.companyRepository.findById(id).orElseThrow(null);
        System.out.println("company1>>>>>>>>>>>" + company1);
         if(company1!=null){
              company1.setDescription(company.getDescription());
              company1.setName(company.getName());
              company1.setJobs(company.getJobs());
            return  this.companyRepository.save(company1);
         }
        return null;
    }

    @Override
    public Company createCompany(Company company) {
        return this.companyRepository.save(company);
    }

    @Override
    public Boolean deleteCompany(int id) {
         if(this.companyRepository.existsById(id)){
              this.companyRepository.deleteById(id);
              return  true;
         }
         else {
             return false;
         }
    }

    @Override
    public Company getCompanyById(int id) {
        Company company = this.companyRepository.findById(id).orElseThrow(null);
        return  company;
    }
}
