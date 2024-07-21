package com.careerhigh.backend.persist.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectId")
    private Long projectId;

    @Column(name = "title")
    private String title;              // 프로젝트 제목

    @Column(name = "description")
    private String description;        // 프로젝트 상세 설명

    @Column(name = "start_date")
    private String startDate;          // 시작예정일

    @Column(name = "period")
    private Integer period;            // 예상기간(월)

    @Column(name = "job_group")
    private String jobGroup;           // 직군

    @Column(name = "job")
    private String job;                // 직무

    @Column(name = "skill")
    private String skill;              // 스킬

    @Column(name = "pay")
    private Integer pay;               // 예상 급여

    @Column(name = "want_career_year")
    private Integer wantCareerYear;    // 희망 경력

    @Column(name = "progress")
    private Double progress;           // 진행률

    @Column(name = "work_style")
    private String workStyle;          // 근무방식

    @Setter
    @Column(name = "client_status")
    private String clientStatus;       // 프로젝트 상태(클라이언트)(CREATE(등록), REQUEST(의뢰), DISCUSSION(협의중) ,ONGOING(진행중), COMPLETE(완료))

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "project")
    private final List<FreelancerProject> freelancerProjects = new ArrayList<>();
}