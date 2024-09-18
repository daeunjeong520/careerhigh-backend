package com.careerhigh.backend.vo.response;

import com.careerhigh.backend.dto.ProjectDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectCreateDetail {

    private Long clientId;
    private String companyName;
    private Long projectId;
    private String title;
    private String description;
    private String startDate;
    private String endDate;
    private Integer period;
    private String jobGroup;
    private String job;
    private String skill;
    private Integer pay;
    private Integer wantCareerYear;
    private String workStyle;

    public static ProjectCreateDetail fromDto(ProjectDto projectDto) {
        return ProjectCreateDetail.builder()
                .clientId(projectDto.getClient().getClientId())
                .companyName(projectDto.getClient().getCompanyName())
                .projectId(projectDto.getProjectId())
                .title(projectDto.getTitle())
                .description(projectDto.getDescription())
                .startDate(projectDto.getStartDate())
                .endDate(projectDto.getEndDate())
                .period(projectDto.getPeriod())
                .jobGroup(projectDto.getJobGroup())
                .job(projectDto.getJob())
                .skill(projectDto.getSkill())
                .pay(projectDto.getPay())
                .wantCareerYear(projectDto.getWantCareerYear())
                .workStyle(projectDto.getWorkStyle())
                .build();
    }
}
