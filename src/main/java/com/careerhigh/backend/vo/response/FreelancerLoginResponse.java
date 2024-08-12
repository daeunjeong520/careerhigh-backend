package com.careerhigh.backend.vo.response;

import com.careerhigh.backend.dto.FreelancerDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FreelancerLoginResponse {

    private Long freelancerId;
    private String freelancerName;

    public static FreelancerLoginResponse fromDto(FreelancerDto freelancerDto) {
        return FreelancerLoginResponse.builder()
                .freelancerId(freelancerDto.getFreelancerId())
                .freelancerName(freelancerDto.getName())
                .build();
    }
}
