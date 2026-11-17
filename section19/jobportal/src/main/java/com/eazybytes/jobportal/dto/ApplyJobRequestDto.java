package com.eazybytes.jobportal.dto;

import jakarta.validation.constraints.NotNull;

public record ApplyJobRequestDto(
        @NotNull(message = "Job id is required")
        Long jobId,
        String coverLetter
) {
}
