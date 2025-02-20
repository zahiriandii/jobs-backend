package com.example.jobapplication.Service;

import com.example.jobapplication.Model.Jobs;

import java.util.List;

public interface JobsService
{
    List<Jobs> getAllJobs();
    Jobs findJobById(Long id);
    Jobs addNewJob (Jobs job);
}
