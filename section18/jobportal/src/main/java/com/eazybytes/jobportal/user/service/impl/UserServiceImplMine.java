/*
package com.eazybytes.jobportal.user.service.impl;

import com.eazybytes.jobportal.constants.ApplicationConstants;
import com.eazybytes.jobportal.dto.JobPortalUserDto;
import com.eazybytes.jobportal.entity.Company;
import com.eazybytes.jobportal.entity.JobPortalUser;
import com.eazybytes.jobportal.entity.Role;
import com.eazybytes.jobportal.repository.CompanyRepository;
import com.eazybytes.jobportal.repository.JobPortalUserRepository;
import com.eazybytes.jobportal.repository.RoleRepository;
import com.eazybytes.jobportal.user.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImplMine implements IUserService {

   private final JobPortalUserRepository jobPortalUserRepository;
    private final RoleRepository roleRepository;
    private final CompanyRepository companyRepository;

    public JobPortalUserDto searchUserByEmail(String email) {
       Optional<JobPortalUser> jobPortalUser =jobPortalUserRepository.findJobPortalUserByEmail(email);
        return transformUserToDto(jobPortalUser.get());
    }

    @Transactional
    @Override
    public JobPortalUserDto elevateToRoleEmployer(Long userId) {
        Optional<JobPortalUser> jobPortalUser =  jobPortalUserRepository.findById(userId);

        if(!jobPortalUser.isPresent()){
            throw new RuntimeException("User not found");
        }

        System.out.println("ROLE_EMPLOYER 1");
        if(jobPortalUser.get().getRole().getName().equals(ApplicationConstants.ROLE_EMPLOYER)){
            System.out.println("ROLE_EMPLOYER 2");
            throw new RuntimeException("User is already assigned the employer role.");
        }

        if(jobPortalUser.get().getRole().getName().equals(ApplicationConstants.ROLE_ADMIN)){
            throw new RuntimeException("A user with an Admin role cannot be an employer.");
        }

      Role role = roleRepository.findRoleByName(ApplicationConstants.ROLE_EMPLOYER).orElseThrow(() -> new RuntimeException("Role not found."));

      jobPortalUser.get().setRole(role);

     jobPortalUserRepository.save(jobPortalUser.get());

      return transformUserToDto(jobPortalUser.get());
    }

    @Transactional
    @Override
    public JobPortalUserDto assignCompany(Long userId, Long companyId) {
        JobPortalUser jobPortalUser =  jobPortalUserRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found "+userId));
        Company company = companyRepository.findById(companyId).orElseThrow(() -> new RuntimeException("Company not found"));

        jobPortalUser.setCompany(company);
//        jobPortalUserRepository.save(jobPortalUser);

        return transformUserToDto(jobPortalUser);
    }

    private JobPortalUserDto transformUserToDto(JobPortalUser jobPortalUser) {
        return new JobPortalUserDto(
                jobPortalUser.getId(),
                jobPortalUser.getName(),
                jobPortalUser.getEmail(),
                jobPortalUser.getMobileNumber(),
                jobPortalUser.getRole().getName()
        );
    }
}
*/
