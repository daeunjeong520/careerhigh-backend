package com.careerhigh.backend.vo.response;

import com.careerhigh.backend.dto.FreelancerProjectDto;
import com.careerhigh.backend.dto.ProjectDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectCommissionResponse {

    private Long freelancerProjectId;
    private String status;

    public static ProjectCommissionResponse fromDto(FreelancerProjectDto freelancerProjectDto) {
        return ProjectCommissionResponse.builder()
                .freelancerProjectId(freelancerProjectDto.getFreelancerProjectId())
                .status(freelancerProjectDto.getStatus())
                .build();
    }
}
