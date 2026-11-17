package com.eazybytes.jobportal.job.service.impl;

import com.eazybytes.jobportal.dto.JobDto;
import com.eazybytes.jobportal.entity.Company;
import com.eazybytes.jobportal.entity.Job;
import com.eazybytes.jobportal.entity.JobPortalUser;
import com.eazybytes.jobportal.job.service.IJobService;
import com.eazybytes.jobportal.job.service.IJobServicePractice;
import com.eazybytes.jobportal.repository.CompanyRepository;
import com.eazybytes.jobportal.repository.JobPortalUserRepository;
import com.eazybytes.jobportal.repository.JobRepository;
import com.eazybytes.jobportal.util.ApplicationUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JobServiceImplPractice implements IJobServicePractice {


    private final CompanyRepository companyRepository;
    private final JobPortalUserRepository jobPortalUserRepository;
    private final JobRepository jobRepository;

    @Override
    public List<JobDto> findJobsByCompany(Long companyId) {
        Optional<Company> company = companyRepository.findById(companyId);

        List<JobDto> jobDtos = List.of();
        if (company.isPresent()) {
            jobDtos = company.get().getJobs().stream()
                    .map(job -> ApplicationUtility.transformJobToDto(job))
                    .collect(Collectors.toList());
        }

        return jobDtos;
    }

    @Transactional
    @Override
    public ResponseEntity<?> updateJobStatus(Long id, String status, String employerEmail) {

        if(!status.equals("ACTIVE") && !status.equals("DRAFT") && !status.equals("CLOSED")){
           return  ResponseEntity.badRequest().body("Invalid status passed");
        }

        System.out.println("here 1");
        JobPortalUser jobPortalUser = jobPortalUserRepository.findJobPortalUserByEmail(employerEmail).get();
        System.out.println("here 2");

        if(jobPortalUser == null){
            return ResponseEntity.badRequest().body("Employer not found");
        }

       if(jobPortalUser.getCompany().getId() == null){
           return ResponseEntity.badRequest().body("Employer has not been assigned to a company");
       }

        System.out.println("here 3");
        System.out.println("jobPortalUser.getCompany().getId():"+jobPortalUser.getCompany().getId());
        System.out.println("jobPortalUser.getCompany().getjobs:"+jobPortalUser.getCompany().getJobs());

        System.out.println("Looking for {}, company jobs: {}"+id+"list:"+
                jobPortalUser.getCompany().getJobs().stream().map(Job::getId).toList());

        Job userJob = jobPortalUser.getCompany().getJobs().stream()
                .filter(job -> job.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(
                        "Job " + id + " not found for this employer"));

        System.out.println("here 4");

       userJob.setStatus(status);

        return ResponseEntity.ok().body(Map.of("message", "Job status updated successfully"));
    }

    @Transactional
    @Override
    public JobDto createJob(JobDto jobDto, String employerEmail) {
        JobPortalUser jobPortalUser = jobPortalUserRepository.findJobPortalUserByEmail(employerEmail).get();

        if(jobPortalUser == null){
            throw new RuntimeException("Employer not found");
        }

        if(jobPortalUser.getCompany().getId() == null){
           throw new RuntimeException("Employer has not been assigned to a company");
        }

       Job job = ApplicationUtility.transformJobDtoToJobEntity(jobDto);
        job.setCompany(jobPortalUser.getCompany());
        job.setStatus("ACTIVE");
        job.setPostedDate(Instant.now());
        jobRepository.save(job);
        return ApplicationUtility.transformJobToDto(job);
    }
}
