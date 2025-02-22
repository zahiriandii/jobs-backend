package com.example.jobapplication.web.RestController;

import com.example.jobapplication.Model.Jobs;
import com.example.jobapplication.Service.JobsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
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
        System.out.println("Jobs retrieved: " + jobs);
        return ResponseEntity.ok(jobs);
    }

    @GetMapping("/{jobId}")
    public ResponseEntity<Jobs> getJobsById (@PathVariable Long jobId)
    {
        Jobs job = jobsService.findJobById(jobId);
        return ResponseEntity.ok(job);
    }

    @PostMapping
    public ResponseEntity<Jobs> addJob (@RequestBody Jobs job)
    {
        Jobs createdjob = jobsService.addNewJob(job);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdjob);
    }

    @PutMapping("/{jobId}")
    public ResponseEntity<Jobs> updateJob (@PathVariable Long jobId,@RequestBody Jobs job)
    {
        Jobs updateJob = jobsService.updateJob(jobId,job);
        return ResponseEntity.ok(updateJob);
    }



}
