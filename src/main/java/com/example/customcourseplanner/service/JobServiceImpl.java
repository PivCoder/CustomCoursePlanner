package com.example.customcourseplanner.service;

import com.example.customcourseplanner.model.Job;
import com.example.customcourseplanner.repositoryes.JobRepository;
import com.example.customcourseplanner.service.api.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;

    @Autowired
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public Job addJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public void deleteJobById(long id) {
        jobRepository.deleteById(id);
    }

    @Override
    public Optional<Job> getJobById(long id) {
        return jobRepository.findById(id);
    }

    @Override
    public Job editJob(Job newJob, long id) {
        return jobRepository.findById(id)
                .map(job -> {
                    job.setName(job.getName());
                    job.setDescription(job.getDescription());
                    return jobRepository.save(job);
                })
                .orElseGet(() -> jobRepository.save(newJob));
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
}
