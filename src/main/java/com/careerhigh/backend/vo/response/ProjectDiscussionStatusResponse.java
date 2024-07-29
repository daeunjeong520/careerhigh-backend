package com.careerhigh.backend.vo.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDiscussionStatusResponse {

    private Long projectId;
    private Long freelancerId;
    private Long clientId;
    private String clientStatus;
    private String freelancerStatus;
}
