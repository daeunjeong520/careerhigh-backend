package com.careerhigh.backend.persist.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FreelancerProject {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "freelancer_project_id")
    private Long freelancerProjectId;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "freelancer_id")
    private Freelancer freelancer;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @Setter
    private String status; // 프리랜서 상태(의뢰받은(COMMISSIONED), 지원한(APPLY), 협의중(DISCUSSION), 진행중(ONGOING), 완료됨(COMPLETE))
}
