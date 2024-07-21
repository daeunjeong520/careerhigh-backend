package com.careerhigh.backend.persist.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FreelancerProject {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "freelancer_project_id")
    private Long freelancerProjectId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "freelancer_id")
    private Freelancer freelancer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    private String status; // 프리랜서 상태(의뢰받은(COMMISSIONED), 지원한(APPLY), 협의중(DISCUSSION), 진행중(ONGOING), 완료됨(COMPLETE))
}
