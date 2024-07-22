package com.careerhigh.backend.vo.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectCommissionCancelRequest {

    private Long projectId;
    private Long freelancerId;

}
