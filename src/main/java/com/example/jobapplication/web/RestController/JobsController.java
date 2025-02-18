package com.example.jobapplication.web.RestController;

import com.example.jobapplication.Model.Jobs;
import com.example.jobapplication.Service.JobsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "http://localhost:5173")
public class JobsController
{
    private final JobsService jobsService;

    public JobsController(JobsService jobsService) {
        this.jobsService = jobsService;
    }

    @GetMapping("/allJobs")
    public ResponseEntity<List<Jobs>> getJobs ()
    {
        List<Jobs> jobs = jobsService.getAllJobs();
        return ResponseEntity.ok(jobs);
    }



}
