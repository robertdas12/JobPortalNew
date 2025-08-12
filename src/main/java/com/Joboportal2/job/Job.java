package com.Joboportal2.job;


import com.Joboportal2.company.Company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Job {


     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private  int id;
     private String jobDescription;
     private String jobTitle;
     private String minSalary;
     private String maxSalary;
     private String location;


     @ManyToOne
     private Company company;





}
