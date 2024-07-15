package com.careerhigh.backend.vo.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientLoginRequest {

    private String email;
    private String password;
}
