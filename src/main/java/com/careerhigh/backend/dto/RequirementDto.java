package com.careerhigh.backend.dto;

import com.careerhigh.backend.persist.entity.Project;
import com.careerhigh.backend.persist.entity.Requirement;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequirementDto {

    private Long requirementId;
    private Project project;
    private String title;
    private String description;
    private String endDate;
    private String comment;
    private boolean isCompleted;

    public static RequirementDto fromEntity(Requirement requirement) {
        return RequirementDto.builder()
                .requirementId(requirement.getRequirementId())
                .project(requirement.getProject())
                .title(requirement.getTitle())
                .description(requirement.getDescription())
                .endDate(requirement.getEndDate().toString())
                .comment(requirement.getComment())
                .isCompleted(requirement.isCompleted())
                .build();
    }
}