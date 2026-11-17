package com.eazybytes.jobportal.user.service;

import com.eazybytes.jobportal.dto.JobPortalUserDto;

public interface IUserServiceMine {
    JobPortalUserDto searchUserByEmail (String email);

    JobPortalUserDto elevateToRoleEmployer(Long userId);

    JobPortalUserDto assignCompany(Long userId, Long companyId);
}
