package com.careerhigh.backend.vo.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequirementCreateRequest {

    private Long projectId;
    private String title;
    private String description;
    private String endDate;
    private String comment;
}
