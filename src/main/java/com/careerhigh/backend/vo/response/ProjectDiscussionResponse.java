package com.careerhigh.backend.vo.response;

import com.careerhigh.backend.dto.FreelancerProjectDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDiscussionResponse {

    private Long freelancerProjectId;
    private String status;

    public static ProjectDiscussionResponse fromDto(FreelancerProjectDto freelancerProjectDto) {
        return ProjectDiscussionResponse.builder()
                .freelancerProjectId(freelancerProjectDto.getFreelancerProjectId())
                .status(freelancerProjectDto.getStatus())
                .build();
    }
}
