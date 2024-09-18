package com.careerhigh.backend.vo.response;

import com.careerhigh.backend.dto.ProjectDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectModifyResponse {

    private Long clientId;
    private Long projectId;

    public static ProjectModifyResponse fromDto(ProjectDto projectDto) {
        return ProjectModifyResponse.builder()
                .clientId(projectDto.getClient().getClientId())
                .projectId(projectDto.getProjectId())
                .build();
    }
}
