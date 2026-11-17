package com.eazybytes.jobportal.job.service;


import com.eazybytes.jobportal.dto.JobDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IJobServicePractice {
    List<JobDto> findJobsByCompany(Long companyId);

    ResponseEntity<?> updateJobStatus(@NotBlank Long id, String status, String employerEmail);

    JobDto createJob(@Valid JobDto jobDto, String name);
}
