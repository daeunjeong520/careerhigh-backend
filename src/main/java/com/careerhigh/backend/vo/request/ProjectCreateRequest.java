package com.careerhigh.backend.vo.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectCreateRequest {

    private Long clientId;          // 클라이언트 아이디
    private String title;           // 프로젝트 제목
    private String description;     // 프로젝트 상세 설명
    private String startDate;       // 시작예정일
    private String endDate;         // 마감예정일
    private Integer period;         // 예상기간(월)
    private String jobGroup;        // 직군
    private String job;             // 직무
    private Integer wantCareerYear; // 희망 경력
    private String workStyle;       // 근무방식
    private Integer pay;            // 희망급여
    private String skill;           // 스킬
}
