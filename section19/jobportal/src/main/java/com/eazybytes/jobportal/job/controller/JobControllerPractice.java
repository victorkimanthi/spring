/*
package com.eazybytes.jobportal.job.controller;

import com.eazybytes.jobportal.dto.JobDto;
import com.eazybytes.jobportal.dto.UserDto;
import com.eazybytes.jobportal.job.service.IJobService;
import com.eazybytes.jobportal.job.service.IJobServicePractice;
import com.eazybytes.jobportal.user.service.IUserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jobs")

public class JobControllerPractice {

    private final IJobServicePractice jobInterface;
    private final IUserService userService;

    @GetMapping(path = "/employer",version = "1.0")
    public ResponseEntity<?> getEmployerJobs(Authentication authentication){

       String employerEmail = authentication.getName();

        Optional<UserDto> userOptional = userService.searchUserByEmail(employerEmail);
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "User not found with email: " + employerEmail));
        }

       if (userOptional.get().getCompanyId() == null){
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                   .body(Map.of("message", "User has not been assigned to a company"));
       }

       List <JobDto> jobs = jobInterface.findJobsByCompany(userOptional.get().getCompanyId());

        return ResponseEntity.ok().body(jobs);
    }

    @PatchMapping(path = "/{id}/status/employer")
    public ResponseEntity<?> updateJobStatus(@PathVariable @Positive Long id, @RequestBody Map<String, Object> requestBody, Authentication authentication){
        String status = (String) requestBody.get("status");

       return jobInterface.updateJobStatus(id,status,authentication.getName());
    }

    @PostMapping(path = "/employer")
    public ResponseEntity<JobDto> createJob(@RequestBody @Valid JobDto jobDto,Authentication authentication){
        JobDto jobDto1 = jobInterface.createJob(jobDto,authentication.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(jobDto1);
    }

}
*/
