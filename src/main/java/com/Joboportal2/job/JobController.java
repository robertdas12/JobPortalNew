package com.Joboportal2.job;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
     private JobService jobService;



                   @GetMapping("/allJobs")
                   public  ResponseEntity<List<Job>>getAllJobs(){
                        List<Job> allJobs =   this.jobService.getAllJob();
                        return  new ResponseEntity<>(allJobs,HttpStatus.OK);
                   }


                   @PostMapping("/create")
                   public  ResponseEntity<String>  addJob(@RequestBody Job job){
                             String result =   this.jobService.addJob(job);
                       return new ResponseEntity<>(result,HttpStatus.CREATED);
                   }

                   @GetMapping("/get/{id}")
                   public ResponseEntity<Job>  getJobById(@PathVariable int id){
                          Job job =  this.jobService.getJObById(id);
                          if(job!=null) {
                              return new ResponseEntity<Job>(job, HttpStatus.OK);
                          }
                        return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
                   }

                   @PutMapping("/update/{id}")
                   public  ResponseEntity<Job>  updateJob(@PathVariable int id, @RequestBody Job job){
                                 Job job1 =  this.jobService.updateJob(id,job);
                       System.out.println(job1 + "**********************");
                                 if(job1!=null)
                                     return  new ResponseEntity<Job>(job1,HttpStatus.OK);
                                 else
                                       return  new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
                   }

                   @DeleteMapping("/delete/{id}")
                   public  ResponseEntity<String> deleteJob(@PathVariable int id){
                            Boolean  result = this.jobService.deleteJob(id);
                            if (result==true){
                                 new ResponseEntity<String>("one user got deleted",HttpStatus.OK);
                            }
                       return  new ResponseEntity<String>("id not found",HttpStatus.NOT_FOUND);
                   }






}
