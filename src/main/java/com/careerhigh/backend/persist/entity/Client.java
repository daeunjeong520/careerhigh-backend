package com.careerhigh.backend.persist.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "client")
public class Client {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "naver_token")
    private String naverToken;

    @Column(name = "kakao_token")
    private String kakaoToken;

    @Column(name = "google_token")
    private String googleToken;

    @Column(name = "email")
    private String email;           // 회원가입 이메일

    @Column(name = "encrypted_pwd")
    private String encryptedPwd;    // 회원가입 패스워드

    // 클라이언트 프로필
    @Column(name = "company_name")
    private String companyName;    // 회사명

    @Column(name = "manager_name")
    private String managerName;    // 담당자명

    @Column(name = "manager_phone")
    private String managerPhone;   // 담당자 연락처

    @Column(name = "managerEmail")
    private String managerEmail;   // 담당자 이메일

    @Column(name = "star_rating")
    private Double starRating;     // 평점

    @OneToMany(mappedBy = "client")
    public List<Project> projectList = new ArrayList<>();

    @Column(name = "fcm_token", length = 500)
    public String fcmToken;

}
