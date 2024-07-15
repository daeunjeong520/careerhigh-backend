package com.careerhigh.backend.vo.response;

import com.careerhigh.backend.dto.ProjectDto;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectInfo {

    private Long projectId;
    private String title;           // 프로젝트 제목
    private String jobGroup;        // 직군
    private String job;             // 직무
    private String workStyle;       // 근무방식(원격/상주)
    private Integer pay;            // 예상 금액
    private String startDate;       // 시작 예정일
    private Integer period;         // 예상 기간

    public static ProjectInfo fromDto(ProjectDto projectDto) {
        return ProjectInfo.builder()
                .projectId(projectDto.getProjectId())
                .title(projectDto.getTitle())
                .jobGroup(projectDto.getJobGroup())
                .job(projectDto.getJob())
                .workStyle(projectDto.getWorkStyle())
                .pay(projectDto.getPay())
                .startDate(projectDto.getStartDate())
                .period(projectDto.getPeriod())
                .build();
    }
}