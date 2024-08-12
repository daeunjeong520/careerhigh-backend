package com.careerhigh.backend.vo.response;

import com.careerhigh.backend.dto.FreelancerProjectDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

// 협의중인 프리랜서 상세 + 클라이언트, 프로젝트 정보 포함
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDiscussionDetail {

    private Long clientId;
    private Long freelancerId;
    private Long projectId;

    private String companyName;
    private String freelancerName;
    private String projectName;
    private String freelancerImgPath;

    // 프리랜서 상세 정보
    private String jobGroup; // 직군
    private String job; // 직무
    private String skill; // 스킬
    private Integer careerYear; // 경력

    private String startDate; // 시작가능일
    private Double starRating; // 평점
    private String proficiency; // 숙련도

    // 프로젝트 상세 정보
    private String title; // 프로젝트명
    private Integer salary; // 예상금액
    private String workStyle; // 근무방식
    private String description; // 프로젝트 상세설명

    private String freelancerStatus; // 프리랜서 상태
}
