package com.careerhigh.backend.vo.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDashboardInfo {

    private Long projectId;
    private String projectTitle; // 프로젝트 이름
    private String companyName; // 클라이언트 이름
    private String freelancerName; // 프리랜서 이름
    private Double progress; // 진행률
    private String startDate; // 시작날짜
    private String endDate;   // 종료날짜
    private Integer totalRequirement; // 전체 요구사항 개수
    private Integer completeRequirement; // 완료한 요구사항 개수
    private Long leftDate; // 남은 날짜
}
