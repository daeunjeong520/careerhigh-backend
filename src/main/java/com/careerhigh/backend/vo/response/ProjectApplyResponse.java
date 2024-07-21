package com.careerhigh.backend.vo.response;

import com.careerhigh.backend.dto.FreelancerProjectDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectApplyResponse {

    private Long freelancerProjectId;
    private String status;

    public static ProjectApplyResponse fromDto(FreelancerProjectDto freelancerProjectDto) {
        return ProjectApplyResponse.builder()
                .freelancerProjectId(freelancerProjectDto.getFreelancerProjectId())
                .status(freelancerProjectDto.getStatus())
                .build();
    }
}
