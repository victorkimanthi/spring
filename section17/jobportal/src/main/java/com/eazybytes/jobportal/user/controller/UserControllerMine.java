/*
package com.eazybytes.jobportal.user.controller;

import com.eazybytes.jobportal.dto.JobPortalUserDto;
import com.eazybytes.jobportal.user.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserControllerMine {

    private final IUserService userService;

    @GetMapping("/search/admin")
    public ResponseEntity<JobPortalUserDto> searchUserByEmail(@RequestParam String email){
       JobPortalUserDto jobPortalUserDto = userService.searchUserByEmail(email);
        return ResponseEntity.status(HttpStatus.OK).body(jobPortalUserDto);
    }

    @PatchMapping("/{userId}/role/employer/admin")
    public ResponseEntity<JobPortalUserDto> elevateRole(@PathVariable Long userId){
        JobPortalUserDto jobPortalUserDto = userService.elevateToRoleEmployer(userId);

        return ResponseEntity.status(HttpStatus.OK).body(jobPortalUserDto);
    }

    @PatchMapping("/{userId}/company/{companyId}/admin")
    public ResponseEntity<JobPortalUserDto> assignCompany(@PathVariable Long userId, @PathVariable Long companyId){
        JobPortalUserDto jobPortalUserDto = userService.assignCompany(userId,companyId);

        return ResponseEntity.status(HttpStatus.OK).body(jobPortalUserDto);
    }
}
*/
