package com.careerhigh.backend.persist.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Requirement {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "requirement_id")
    private Long requirementId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "title")
    private String title; // 요구사항 제목

    @Column(name = "description")
    private String description; // 상세 설명

    @Column(name = "end_date")
    private LocalDate endDate; // 마감날짜

    @Column(name = "comment")
    private String comment; // 코멘트

    @Column(name = "is_completed")
    private boolean isCompleted; // 완료 여부

}
