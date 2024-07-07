package com.careerhigh.backend.vo.response;

import com.careerhigh.backend.dto.FreelancerDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FreelancerDetail {

    private Long freelancerId;
    private String name; // 이름
    private String jobGroup; // 직군
    private String job; // 직무
    private String workStyle; // 원격/상주
    private Integer careerYear; // 경력
    private Double starRating; // 평점
    private String profileImg; // 프로필 이미지
    private String skill; // 스킬
    private String link; // 링크
    private String proficiency; // 숙련도
    private String description;

    public static FreelancerDetail fromDto(FreelancerDto freelancerDto) {
        return FreelancerDetail.builder()
                .freelancerId(freelancerDto.getFreelancerId())
                .name(freelancerDto.getName())
                .jobGroup(freelancerDto.getJobGroup())
                .job(freelancerDto.getJob())
                .workStyle(freelancerDto.getWorkStyle())
                .careerYear(freelancerDto.getCareerYear())
                .starRating(freelancerDto.getStarRating())
                .profileImg(freelancerDto.getProfileImg())
                .skill(freelancerDto.getSkillDto().getName())
                .link(freelancerDto.getSkillDto().getLink())
                .proficiency(freelancerDto.getSkillDto().getProficiency())
                .description(freelancerDto.getSkillDto().getDescription())
                .build();
    }
}
