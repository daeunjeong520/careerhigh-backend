package com.careerhigh.backend.vo.response;

import com.careerhigh.backend.dto.RequirementDto;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequirementInfo {

    private Long requirementId;
    private String title;
    private String description;
    private String endDate;
    private String comment;
    private Boolean isCompleted;
    private String remainDate;

    public static RequirementInfo fromDto(RequirementDto requirementDto) {

        return RequirementInfo.builder()
                .requirementId(requirementDto.getRequirementId())
                .title(requirementDto.getTitle())
                .description(requirementDto.getDescription())
                .endDate(requirementDto.getEndDate())
                .comment(requirementDto.getComment())
                .isCompleted(requirementDto.isCompleted())
                .remainDate(requirementDto.getRemainDate())
                .build();
    }
}
