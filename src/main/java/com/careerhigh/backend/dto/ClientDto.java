package com.careerhigh.backend.dto;

import com.careerhigh.backend.persist.entity.Client;
import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDto {

    private Long clientId;
    private String email;
    private String encryptedPwd;
    private String name;
    private String phoneNumber;
    private String companyName; // 회사명
    private String managerName; // 담당자명
    private String managerPhone; // 담당자 연락처
    private Double starRating; // 평점


    public static ClientDto fromEntity(Client client) {
        return ClientDto.builder()
                .clientId(client.getClientId())
                .email(client.getEmail())
                .encryptedPwd(client.getEncryptedPwd())
                .name(client.getName())
                .phoneNumber(client.getPhoneNumber())
                .companyName(client.getCompanyName())
                .managerName(client.getManagerName())
                .managerPhone(client.getManagerPhone())
                .starRating(client.getStarRating())
                .build();
    }
}
