package com.careerhigh.backend.vo.response;

import com.careerhigh.backend.dto.RequirementDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequirementCreateResponse {

    private Long requirementId;
    private Long projectId;
    private boolean isCompleted; // 완료여부

    public static RequirementCreateResponse fromDto(RequirementDto requirementDto) {
        return RequirementCreateResponse.builder()
                .requirementId(requirementDto.getRequirementId())
                .projectId(requirementDto.getProject().getProjectId())
                .isCompleted(requirementDto.isCompleted())
                .build();
    }
}
