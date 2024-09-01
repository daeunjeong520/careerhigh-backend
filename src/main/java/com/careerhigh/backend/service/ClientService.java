package com.careerhigh.backend.service;

import com.careerhigh.backend.dto.ClientDto;
import com.careerhigh.backend.persist.entity.Client;
import com.careerhigh.backend.persist.repository.ClientRepository;
import com.careerhigh.backend.vo.response.ClientLoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    // 회원가입
    @Transactional
    public ClientDto signup(String naverToken, String kakaoToken, String googleToken, String email, String password, String companyName, String managerName, String managerPhone, String managerEmail, String fcmToken) {
        Client client = Client.builder()
                .email(email)
                .encryptedPwd(password)
                .naverToken(naverToken)
                .kakaoToken(kakaoToken)
                .googleToken(googleToken)
                .companyName(companyName)
                .managerName(managerName)
                .managerPhone(managerPhone)
                .managerEmail(managerEmail)
                .fcmToken(fcmToken)
                .build();

        return ClientDto.fromEntity(clientRepository.save(client));
    }
    // 네이버로 로그인
    public ClientLoginResponse loginWithNaver(String naverToken) {
        Optional<Client> findClient = clientRepository.findByNaverToken(naverToken);

        if(findClient.isPresent()) {
            Client client = findClient.get();

            return ClientLoginResponse.builder()
                    .clientId(client.getClientId())
                    .companyName(client.getCompanyName())
                    .managerName(client.getManagerName())
                    .managerPhone(client.getManagerPhone())
                    .managerEmail(client.getManagerEmail())
                    .status("OK")
                    .build();
        }else {
            return ClientLoginResponse.builder()
                    .status("NOT_FOUND_USER")
                    .build();
        }
    }

    // 카카오로 로그인
    public ClientLoginResponse loginWithKakao(String kakaoToken) {
        Optional<Client> findClient = clientRepository.findByKakaoToken(kakaoToken);

        if(findClient.isPresent()) {
            Client client = findClient.get();

            return ClientLoginResponse.builder()
                    .clientId(client.getClientId())
                    .companyName(client.getCompanyName())
                    .managerName(client.getManagerName())
                    .managerPhone(client.getManagerPhone())
                    .managerEmail(client.getManagerEmail())
                    .status("OK")
                    .build();
        }else {
            return ClientLoginResponse.builder()
                    .status("NOT_FOUND_USER")
                    .build();
        }
    }

    // 클라이언트 상세 조회
    public ClientDto getClient(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Not Found Client"));
        return ClientDto.fromEntity(client);
    }

    // 로그인
    @Transactional
    public ClientDto login(String email, String password) {
        Client client = clientRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Not found Email"));

        if(!client.getEncryptedPwd().equals(password)) {
            throw new RuntimeException("Do not match password");
        }

        return ClientDto.fromEntity(client);
    }
}