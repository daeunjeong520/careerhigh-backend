package com.careerhigh.backend.vo.response;

import com.careerhigh.backend.dto.FreelancerDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FreelancerInfo {

    private Long freelancerId;
    private String name;
    private String jobGroup; // 직군
    private String job; // 직무
    private String workStyle; // 원격/상주
    private Integer careerYear; // 경력
    private Double starRating; // 평점
    private String profileImg; // 프로필 이미지

    public static FreelancerInfo fromDto(FreelancerDto freelancerDto) {
        return FreelancerInfo.builder()
                .freelancerId(freelancerDto.getFreelancerId())
                .name(freelancerDto.getName())
                .jobGroup(freelancerDto.getJobGroup())
                .job(freelancerDto.getJob())
                .workStyle(freelancerDto.getWorkStyle())
                .careerYear(freelancerDto.getCareerYear())
                .starRating(freelancerDto.getStarRating())
                .profileImg(freelancerDto.getProfileImg())
                .build();
    }
}