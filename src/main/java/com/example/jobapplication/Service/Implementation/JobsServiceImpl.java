package com.example.jobapplication.Service.Implementation;

import com.example.jobapplication.Model.Jobs;
import com.example.jobapplication.Repository.JobsRepository;
import com.example.jobapplication.Service.JobsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobsServiceImpl implements JobsService
{

    private final JobsRepository jobsRepository;

    public JobsServiceImpl(JobsRepository jobsRepository) {
        this.jobsRepository = jobsRepository;
    }


    @Override
    public List<Jobs> getAllJobs() {
        return jobsRepository.findAll();
    }
}
