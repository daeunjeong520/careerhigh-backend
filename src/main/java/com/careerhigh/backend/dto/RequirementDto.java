package com.careerhigh.backend.dto;

import com.careerhigh.backend.persist.entity.Project;
import com.careerhigh.backend.persist.entity.Requirement;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Slf4j
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
    private String remainDate;

    public static RequirementDto fromEntity(Requirement requirement) {

        LocalDate startDate = LocalDate.now(); // 현재 날짜 기준
        LocalDate endDate = requirement.getEndDate();
        Long dDay = ChronoUnit.DAYS.between(startDate, endDate);

        return RequirementDto.builder()
                .requirementId(requirement.getRequirementId())
                .project(requirement.getProject())
                .title(requirement.getTitle())
                .description(requirement.getDescription())
                .endDate(requirement.getEndDate().toString())
                .comment(requirement.getComment())
                .isCompleted(requirement.isCompleted())
                .remainDate(dDay.toString())
                .build();
    }
}