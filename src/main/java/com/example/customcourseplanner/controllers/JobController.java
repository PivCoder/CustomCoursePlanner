package com.example.customcourseplanner.controllers;

import com.example.customcourseplanner.model.Job;
import com.example.customcourseplanner.service.JobServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class JobController {
    private final JobServiceImpl jobService;

    public JobController(JobServiceImpl jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public String showJobs(Model model){
        List<Job> jobList = jobService.getAllJobs();
        model.addAttribute("jobList", jobList);
        return "jobs";
    }

    @GetMapping("/jobs/{id}")
    public String showJob(@PathVariable("id") long id, Model model){
        Optional<Job> job = jobService.getJobById(id);
        List<Job> jobList = new ArrayList<>();
        job.ifPresent(jobList::add);
        model.addAttribute("jobList", jobList);
        return "jobs"; //TODO используем одну и ту же страницу с разными параметрами
    }

    @GetMapping("/new_job")
    public String addJob(){
        return "/newJob";
    }

    @PostMapping("/new_job")
    public String jobPostAdd(@ModelAttribute Job job){
        jobService.addJob(job); //TODO скорее всего некорректно
        return "redirect:/jobs";
    }

    @GetMapping("/jobs/{id}/edit")
    public String editJob(@PathVariable("id") long id, Model model){
        Optional<Job> job = jobService.getJobById(id);
        model.addAttribute("job", job);
        return "editJob";
    }

    @PostMapping("/jobs/{id}/edit")
    public String jobPostEdit(@ModelAttribute Job job){
        jobService.editJob(job, job.getId());
        return "redirect:/jobs";
    }

    @PostMapping("/jobs/{id}/delete")
    public String jobPostDelete(@PathVariable long id){
        jobService.deleteJobById(id);
        return "redirect:/jobs";
    }
}
