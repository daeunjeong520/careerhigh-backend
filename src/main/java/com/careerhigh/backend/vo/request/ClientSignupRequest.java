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

    private String naverToken;
    private String kakaoToken;
    private String googleToken;

    private String companyName;
    private String managerName;
    private String managerPhone;
    private String managerEmail;
    private String fcmToken;
}
