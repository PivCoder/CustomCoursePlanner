package com.example.customcourseplanner.rest;

import com.example.customcourseplanner.model.Job;
import com.example.customcourseplanner.service.JobServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class JobRestController {
    private final JobServiceImpl jobService;

    JobRestController(JobServiceImpl jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    List<Job> getAll(){
        return jobService.getAllJobs();
    }
}
