package com.eazybytes.jobportal.repository;

import com.eazybytes.jobportal.entity.JobPortalUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobPortalUserRepositoryMine extends JpaRepository<JobPortalUser, Long> {
    Optional<JobPortalUser> readUserByEmailOrMobileNumber(String email, String mobileNumber);

//    Optional<JobPortalUser> findJobPortalUserByEmail(String email);
     Optional<JobPortalUser> findJobPortalUserByEmail(String email);
}