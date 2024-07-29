package com.careerhigh.backend.vo.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDiscussionStatusRequest {

    private Long freelancerId;
    private Long projectId;
    private String status;
}
