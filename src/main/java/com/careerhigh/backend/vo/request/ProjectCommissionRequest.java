package com.careerhigh.backend.vo.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectCommissionRequest {

    /**
     * 클라이언트 A가 프리랜서 B에게 프로젝트 선택 후 의뢰!(commission)
     */
    private Long freelancerId; // 프리랜서 아이디
    private Long projectId;    // 프로젝트 아이디
}
