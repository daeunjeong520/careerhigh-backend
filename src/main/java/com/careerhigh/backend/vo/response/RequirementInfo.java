package com.careerhigh.backend.vo.response;

import com.careerhigh.backend.dto.RequirementDto;
import lombok.*;

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
    private boolean isCompleted;

    public static RequirementInfo fromDto(RequirementDto requirementDto) {
        return RequirementInfo.builder()
                .requirementId(requirementDto.getRequirementId())
                .title(requirementDto.getTitle())
                .description(requirementDto.getDescription())
                .endDate(requirementDto.getEndDate())
                .comment(requirementDto.getComment())
                .isCompleted(requirementDto.isCompleted())
                .build();
    }
}
