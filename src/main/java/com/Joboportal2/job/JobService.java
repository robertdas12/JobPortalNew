package com.Joboportal2.job;

import java.util.List;

public interface JobService {

      public String addJob(Job job);
      public List<Job> getAllJob();
      public  Job getJObById(int id);
      public  Job updateJob(int id,Job job);
      public   boolean deleteJob(int id);
}
