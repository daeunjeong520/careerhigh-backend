package com.careerhigh.backend.dto;

import com.careerhigh.backend.persist.entity.Freelancer;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FreelancerDto {

    private Long freelancerId;
    private String name;
    private String email;
    private String encryptedPwd;
    private String phoneNumber;
    private Boolean hasCareer; // 경험 유무
    private Integer careerYear; // 경력기간
    private String workStyle; // 원격/상주
    private String jobGroup; // 직군
    private String job; // 직무
    private Double starRating; // 평점
    private String profileImg; // 프로필 이미지

    public static FreelancerDto fromEntity(Freelancer freelancer) {
        return FreelancerDto.builder()
                .freelancerId(freelancer.getFreelancerId())
                .name(freelancer.getName())
                .email(freelancer.getEmail())
                .encryptedPwd(freelancer.getEncryptedPwd())
                .phoneNumber(freelancer.getPhoneNumber())
                .hasCareer(freelancer.getHasCareer())
                .careerYear(freelancer.getCareerYear())
                .workStyle(freelancer.getWorkStyle())
                .jobGroup(freelancer.getJobGroup())
                .job(freelancer.getJob())
                .starRating(freelancer.getStarRating())
                .profileImg(freelancer.getProfileImg())
                .build();
    }
}