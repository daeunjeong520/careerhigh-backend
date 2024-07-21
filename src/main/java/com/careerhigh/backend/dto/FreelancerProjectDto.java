package com.careerhigh.backend.dto;

import com.careerhigh.backend.persist.entity.Freelancer;
import com.careerhigh.backend.persist.entity.FreelancerProject;
import com.careerhigh.backend.persist.entity.Project;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FreelancerProjectDto {

    private Long freelancerProjectId;
    private Freelancer freelancer;
    private Project project;
    private String status;  // 상태

    public static FreelancerProjectDto fromEntity(FreelancerProject freelancerProject) {
        return FreelancerProjectDto.builder()
                .freelancerProjectId(freelancerProject.getFreelancerProjectId())
                .freelancer(freelancerProject.getFreelancer())
                .project(freelancerProject.getProject())
                .status(freelancerProject.getStatus())
                .build();
    }
}
