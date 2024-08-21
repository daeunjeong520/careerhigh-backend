package com.careerhigh.backend.vo.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequirementModifyRequest {

    private Long requirementId;
    private String title;
    private String description;
    private String endDate;
    private String comment;
}
