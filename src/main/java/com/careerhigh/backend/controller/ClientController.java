package com.careerhigh.backend.controller;

import com.careerhigh.backend.dto.ClientDto;
import com.careerhigh.backend.service.ClientService;
import com.careerhigh.backend.vo.request.ClientSignupRequest;
import com.careerhigh.backend.vo.response.ClientInfo;
import com.careerhigh.backend.vo.response.ClientLoginResponse;
import com.careerhigh.backend.vo.response.ClientSignupResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
                        request.getNaverToken(),
                        request.getKakaoToken(),
                        request.getGoogleToken(),
                        request.getEmail(),
                        request.getPassword(),
                        request.getCompanyName(),
                        request.getManagerName(),
                        request.getManagerPhone(),
                        request.getManagerEmail(),
                        request.getFcmToken()
                )
        );
    }

    // 클라이언트 상세 조회
    @GetMapping("/api/clients/{clientId}")
    public ClientInfo getClient(@PathVariable("clientId") Long clientId) {
        return ClientInfo.fromDto(clientService.getClient(clientId));
    }

    // 네이버 회원 검증
    @GetMapping("/api/clients/login/naver")
    public ClientLoginResponse loginWithNaver(@RequestParam("naverToken") String naverToken) {
        return clientService.loginWithNaver(naverToken);
    }

    @GetMapping("/api/clients/login/kakao")
    public ClientLoginResponse loginWithKakao(@RequestParam("kakaoToken") String kakaoToken) {
        return clientService.loginWithKakao(kakaoToken);
    }
}