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
@Table(name = "freelancer")
public class Freelancer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "freelancer_id")
    private Long freelancerId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "encrypted_pwd")
    private String encryptedPwd;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "has_career")
    private Boolean hasCareer; // 경력 유무

    @Column(name = "career_year")
    private Integer careerYear; // 경력기간

    @Column(name = "work_style")
    private String workStyle; // 원격/상주

    @Column(name = "job_group")
    private String jobGroup; // 직군

    @Column(name = "job")
    private String job; // 직무

    @Column(name = "star_rating")
    private Double starRating; // 평점

    @Column(name = "profile_img")
    private String profileImg; // 프로필 이미지

    @OneToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @Column(name = "fcm_token", length = 500)
    private String fcmToken;
}