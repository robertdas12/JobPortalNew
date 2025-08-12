package com.Joboportal2.review;


import com.Joboportal2.company.Company;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     private String title;
     private String description;
     private double rating;

     @JsonIgnore
     @ManyToOne
     private Company company;
}
