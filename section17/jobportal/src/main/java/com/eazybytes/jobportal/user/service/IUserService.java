package com.eazybytes.jobportal.user.service;

import com.eazybytes.jobportal.dto.CompanyDto;
import com.eazybytes.jobportal.dto.JobPortalUserDto;
import com.eazybytes.jobportal.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    Optional<UserDto> searchUserByEmail (String email);

    UserDto elevateToEmployer(Long userId);

    UserDto assignCompanyToEmployer(Long userId, Long companyId);
}
