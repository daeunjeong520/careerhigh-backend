package com.careerhigh.backend.vo.response;

import com.careerhigh.backend.dto.ClientDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientInfo {

    private Long clientId;
    private String companyName; // 회사명
    private String managerName; // 담당자명
    private String managerPhone; // 담당자 연락처
    private String managerEmail; // 담당자 이메일

    public static ClientInfo fromDto(ClientDto clientDto) {
        return ClientInfo.builder()
                .clientId(clientDto.getClientId())
                .companyName(clientDto.getCompanyName())
                .managerName(clientDto.getManagerName())
                .managerPhone(clientDto.getManagerPhone())
                .managerEmail(clientDto.getManagerEmail())
                .build();
    }
}
