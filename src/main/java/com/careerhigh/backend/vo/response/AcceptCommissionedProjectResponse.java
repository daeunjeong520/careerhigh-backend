package com.careerhigh.backend.vo.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AcceptCommissionedProjectResponse {

    private Long freelancerId;
    private Long projectId;
    private String status;
}
