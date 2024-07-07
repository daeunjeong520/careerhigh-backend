package com.careerhigh.backend.controller;

import com.careerhigh.backend.service.ClientService;
import com.careerhigh.backend.vo.request.ClientSignupRequest;
import com.careerhigh.backend.vo.response.ClientSignupResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    // 회원가입 & 프로필 생성
    @PostMapping("/api/clients/signup")
    public ClientSignupResponse signup(@RequestBody ClientSignupRequest request) {
        return ClientSignupResponse.fromDto(
                clientService.signup(
                        request.getEmail(),
                        request.getPassword(),
                        request.getName(),
                        request.getPhoneNumber(),
                        request.getCompanyName(),
                        request.getManagerName(),
                        request.getManagerPhone()
                )
        );
    }
}