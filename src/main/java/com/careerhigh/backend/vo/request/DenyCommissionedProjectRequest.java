package com.careerhigh.backend.vo.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DenyCommissionedProjectRequest {

    private Long freelancerId;
    private Long projectId;
}
