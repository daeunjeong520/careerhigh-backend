package com.careerhigh.backend.vo.response;

import com.careerhigh.backend.dto.ClientDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientLoginResponse {

    private Long clientId;
    private String name;

    public static ClientLoginResponse fromDto(ClientDto clientDto) {
        return ClientLoginResponse.builder()
                .clientId(clientDto.getClientId())
                .name(clientDto.getName())
                .build();
    }
}
