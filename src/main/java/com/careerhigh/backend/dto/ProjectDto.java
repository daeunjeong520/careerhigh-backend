package com.careerhigh.backend.dto;

import com.careerhigh.backend.persist.entity.Client;
import com.careerhigh.backend.persist.entity.Freelancer;
import com.careerhigh.backend.persist.entity.Project;
import lombok.*;

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
    private Freelancer freelancer;   // 프리랜서
    private String freelancerStatus; // 프로젝트 상태(프리랜서)

    public static ProjectDto fromEntity(Project project) {
        if (project.getFreelancer() == null) {
            return ProjectDto.builder()
                    .projectId(project.getProjectId())
                    .title(project.getTitle())
                    .description(project.getDescription())
                    .startDate(project.getStartDate())
                    .period(project.getPeriod())
                    .jobGroup(project.getJobGroup())
                    .job(project.getJob())
                    .wantCareerYear(project.getWantCareerYear())
                    .progress(project.getProgress())
                    .workStyle(project.getWorkStyle())
                    .pay(project.getPay())
                    .skill(project.getSkill())
                    .clientStatus(project.getClientStatus())
                    .client(project.getClient())
                    .build();
        }
        return ProjectDto.builder()
                .projectId(project.getProjectId())
                .title(project.getTitle())
                .description(project.getDescription())
                .startDate(project.getStartDate())
                .period(project.getPeriod())
                .jobGroup(project.getJobGroup())
                .job(project.getJob())
                .wantCareerYear(project.getWantCareerYear())
                .progress(project.getProgress())
                .workStyle(project.getWorkStyle())
                .pay(project.getPay())
                .skill(project.getSkill())
                .client(project.getClient())
                .freelancer(project.getFreelancer())
                .clientStatus(project.getClientStatus())
                .freelancerStatus(project.getFreelancerStatus())
                .build();
    }
}
