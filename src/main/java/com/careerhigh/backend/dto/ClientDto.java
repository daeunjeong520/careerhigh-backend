package com.careerhigh.backend.dto;

import com.careerhigh.backend.persist.entity.Client;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDto {

    private Long clientId;
    private String naverToken;
    private String kakaoToken;
    private String googleToken;
    private String email;
    private String encryptedPwd;
    private String companyName; // 회사명
    private String managerName; // 담당자명
    private String managerPhone; // 담당자 연락처
    private String managerEmail; // 담당자 이메일
    private Double starRating; // 평점


    public static ClientDto fromEntity(Client client) {
        return ClientDto.builder()
                .clientId(client.getClientId())
                .naverToken(client.getNaverToken())
                .kakaoToken(client.getKakaoToken())
                .googleToken(client.getGoogleToken())
                .email(client.getEmail())
                .encryptedPwd(client.getEncryptedPwd())
                .companyName(client.getCompanyName())
                .managerName(client.getManagerName())
                .managerPhone(client.getManagerPhone())
                .managerEmail(client.getManagerEmail())
                .starRating(client.getStarRating())
                .build();
    }
}
