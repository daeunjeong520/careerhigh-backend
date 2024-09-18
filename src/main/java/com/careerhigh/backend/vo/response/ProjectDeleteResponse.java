package com.careerhigh.backend.vo.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDeleteResponse {

    private Long projectId;
    private String status;

    public static ProjectDeleteResponse from(Long projectId, String status) {
        return ProjectDeleteResponse.builder()
                .projectId(projectId)
                .status(status)
                .build();
    }
}
