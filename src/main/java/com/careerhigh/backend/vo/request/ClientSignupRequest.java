package com.careerhigh.backend.vo.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientSignupRequest {

    private String email;
    private String password;
    private String name;
    private String phoneNumber;

    private String companyName;
    private String managerName;
    private String managerPhone;
}
