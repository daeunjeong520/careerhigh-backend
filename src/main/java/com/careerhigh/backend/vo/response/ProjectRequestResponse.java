package com.careerhigh.backend.vo.response;

import com.careerhigh.backend.dto.ProjectDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectRequestResponse {

    private Long clientId;
    private Long freelancerId;
    private Long projectId;

    public static ProjectRequestResponse fromDto(ProjectDto projectDto) {
        return ProjectRequestResponse.builder()
                .clientId(projectDto.getClient().getClientId())
                .freelancerId(projectDto.getFreelancer().getFreelancerId())
                .projectId(projectDto.getProjectId())
                .build();
    }
}
