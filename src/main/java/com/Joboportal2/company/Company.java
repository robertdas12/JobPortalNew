package com.Joboportal2.company;

import com.Joboportal2.job.Job;
import com.Joboportal2.review.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
      private int id;
      private String name;
      private String description;

      @OneToMany(mappedBy = "company")
      @JsonIgnore
      private List<Job> jobs;

      @OneToMany(mappedBy =  "company")
      private List<Review> reviews;
}
