package com.careerhigh.backend.vo.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectApplyRequest {

    /**
     * 프리랜서가 프로젝트에 지원!
     */
    private Long freelancerId;
    private Long projectId;
}
