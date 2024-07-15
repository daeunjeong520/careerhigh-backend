package com.careerhigh.backend.vo.response;

import com.careerhigh.backend.dto.ProjectDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectCreateResponse {

    private Long clientId;
    private Long projectId;

    public static ProjectCreateResponse fromDto(ProjectDto projectDto) {
        return ProjectCreateResponse.builder()
                .clientId(projectDto.getClient().getClientId())
                .projectId(projectDto.getProjectId())
                .build();
    }
}
