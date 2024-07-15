package com.careerhigh.backend.vo.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectRequestRequest {

    private Long freelancerId;
    private Long projectId;
}
