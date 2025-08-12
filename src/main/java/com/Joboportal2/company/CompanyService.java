package com.Joboportal2.company;

import java.util.List;

public interface CompanyService {

      public List<Company> getAllCompanies();
      public  Company updateCompany(int id,Company company);
      public  Company createCompany(Company company);
      public  Boolean deleteCompany(int id);
      public Company getCompanyById(int id);

}
