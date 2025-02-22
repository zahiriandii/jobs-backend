package com.example.jobapplication.Service.Implementation;

import com.example.jobapplication.Model.Company;
import com.example.jobapplication.Model.Jobs;
import com.example.jobapplication.Repository.CompanyRepository;
import com.example.jobapplication.Repository.JobsRepository;
import com.example.jobapplication.Service.JobsService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobsServiceImpl implements JobsService
{

    private final JobsRepository jobsRepository;
    private final CompanyRepository companyRepository;

    public JobsServiceImpl(JobsRepository jobsRepository, CompanyRepository companyRepository) {
        this.jobsRepository = jobsRepository;
        this.companyRepository = companyRepository;
    }



    @Override
    public List<Jobs> getAllJobs() {
        return jobsRepository.findAll();
    }

    @Override
    public Jobs findJobById(Long id) {
        Optional<Jobs> job = jobsRepository.findById(id);
        return  job.get();

    }

    @Override
    public Jobs addNewJob(Jobs job) {
        Jobs newJob = new Jobs();
        newJob.setTitle(job.getTitle());
        newJob.setType(job.getType());
        newJob.setSalary(job.getSalary());
        newJob.setDescription(job.getDescription());
        newJob.setLocation(job.getLocation());

        Company existingCompany = companyRepository.findByName(job.getCompany().getName());
        if (existingCompany == null)
        {
            Company company = new Company();
            company.setName(job.getCompany().getName());
            company.setDescription(job.getCompany().getDescription());
            company.setContactEmail(job.getCompany().getContactEmail());
            company.setContactPhone(job.getCompany().getContactPhone());
            existingCompany = companyRepository.save(company);
        }
        newJob.setCompany(existingCompany);


       return jobsRepository.save(newJob);
    }

    @Transactional
    @Override
    public Jobs updateJob(Long jobId, Jobs job) {
        Jobs updateJob = jobsRepository.findById(jobId)
                .orElseThrow(() -> new EntityNotFoundException("Job not found with ID: " + jobId));

        updateJob.setTitle(job.getTitle());
        updateJob.setType(job.getType());
        updateJob.setDescription(job.getDescription());
        updateJob.setLocation(job.getLocation());
        updateJob.setSalary(job.getSalary());

        if (job.getCompany() != null && job.getCompany().getName() != null) {
            Company updateCompany = companyRepository.findByName(job.getCompany().getName());

            // Updating company details
            updateCompany.setDescription(job.getCompany().getDescription());
            updateCompany.setName(job.getCompany().getName());
            updateCompany.setContactEmail(job.getCompany().getContactEmail());
            updateCompany.setContactPhone(job.getCompany().getContactPhone());

            // Explicitly saving the updated company before linking it to the job
            companyRepository.save(updateCompany);

            // Reassign the updated company to the job
            updateJob.setCompany(updateCompany);
        }

        // Save the job entity
        return jobsRepository.save(updateJob);

    }

    @Override
    public void deleteJob(Long jobId) {
        jobsRepository.deleteById(jobId);
    }


}
