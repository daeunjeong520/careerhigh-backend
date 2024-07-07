package com.careerhigh.backend.vo.response;


import com.careerhigh.backend.dto.ClientDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientSignupResponse {

    private Long clientId;
    private String name;
    private String companyName;
    private String managerName;
    private String managerPhone;

    public static ClientSignupResponse fromDto(ClientDto clientDto) {
        return ClientSignupResponse.builder()
                .clientId(clientDto.getClientId())
                .name(clientDto.getName())
                .companyName(clientDto.getCompanyName())
                .managerName(clientDto.getManagerName())
                .managerPhone(clientDto.getManagerPhone())
                .build();
    }
}