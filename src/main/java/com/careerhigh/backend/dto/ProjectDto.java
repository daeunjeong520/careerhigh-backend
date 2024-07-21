package com.careerhigh.backend.dto;

import com.careerhigh.backend.persist.entity.Client;
import com.careerhigh.backend.persist.entity.FreelancerProject;
import com.careerhigh.backend.persist.entity.Project;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDto {

    private Long projectId;
    private String title;            // 프로젝트 제목
    private String description;      // 프로젝트 상세 설명
    private String startDate;        // 시작예정일
    private Integer period;          // 예상기간(월)
    private String jobGroup;         // 직군
    private String job;              // 직무
    private Integer pay;             // 급여
    private String skill;            // 스킬
    private Integer wantCareerYear;  // 희망 경력
    private Double progress;         // 진행률
    private String workStyle;        // 근무방식
    private Client client;           // 클라이언트
    private String clientStatus;     // 프로젝트 상태(클라이언트)
    private List<FreelancerProject> freelancerProjects;

    public static ProjectDto fromEntity(Project project) {
        return ProjectDto.builder()
                .projectId(project.getProjectId())
                .title(project.getTitle())
                .description(project.getDescription())
                .startDate(project.getStartDate())
                .period(project.getPeriod())
                .jobGroup(project.getJobGroup())
                .job(project.getJob())
                .pay(project.getPay())
                .skill(project.getSkill())
                .wantCareerYear(project.getWantCareerYear())
                .progress(project.getProgress())
                .workStyle(project.getWorkStyle())
                .client(project.getClient())
                .clientStatus(project.getClientStatus())
                .freelancerProjects(project.getFreelancerProjects())
                .build();
    }
}
