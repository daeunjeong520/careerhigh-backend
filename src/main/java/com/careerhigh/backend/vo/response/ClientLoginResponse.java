package com.careerhigh.backend.vo.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientLoginResponse {

    private Long clientId;
    private String companyName;
    private String managerName;
    private String managerPhone;
    private String managerEmail;
    private String status;
}
