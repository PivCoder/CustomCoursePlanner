package com.example.customcourseplanner.service.api;

import com.example.customcourseplanner.model.Job;

import java.util.List;
import java.util.Optional;

public interface JobService {
    Job addJob(Job job);
    void deleteJobById(long id);
    Optional<Job> getJobById(long id);
    Job editJob(Job job, long id);
    List<Job> getAllJobs();
}
