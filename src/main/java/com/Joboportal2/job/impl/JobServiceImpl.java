package com.Joboportal2.job.impl;

import com.Joboportal2.job.Job;
import com.Joboportal2.job.JobRepository;
import com.Joboportal2.job.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class JobServiceImpl implements JobService {


      @Autowired
      private JobRepository jobRepository;
//    List<Job> dummyJob = new ArrayList<>();
    @Override
    public String addJob(Job job) {
         Job job1 = this.jobRepository.save(job);
         if(job1!=null)
              return  "one job created";
         else
             return  null;
    }

    @Override
    public List<Job> getAllJob() {
        return this.jobRepository.findAll();

    }

    @Override
    public Job getJObById(int id) {
          Job job =  this.jobRepository.findById(id).orElse(null);
           return job;
    }

    @Override
    public Job updateJob(int id, Job job) {
          Job job1 = this.jobRepository.findById(id).orElseThrow(null);
          if(job1!=null){
               job1.setJobDescription(job.getJobDescription());
               job1.setJobTitle(job.getJobTitle());
               job1.setMinSalary(job.getMinSalary());
               job1.setMaxSalary(job.getMaxSalary());
               job1.setLocation(job.getLocation());
               job1.setCompany(job.getCompany());
              System.out.println(job1.getCompany() + "^^^^^^^^^^^^^^^^^^");
               return this.jobRepository.save(job1);
          }
          return  null;
    }

    @Override
    public boolean deleteJob(int id) {
           this.jobRepository.deleteById(id);
           return  true;

    }
}
