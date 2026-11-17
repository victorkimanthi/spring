package com.eazybytes.jobportal.dto;

import java.io.Serializable;
import java.time.Instant;

public record JobPortalUserDto(Long userId,
        String name,
        String email,
        String mobileNumber,
        String role
    )  implements Serializable {
}
