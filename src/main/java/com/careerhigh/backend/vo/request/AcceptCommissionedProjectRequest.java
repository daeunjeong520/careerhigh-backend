package com.careerhigh.backend.vo.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AcceptCommissionedProjectRequest {

    private Long freelancerId;
    private Long projectId;
}
