package com.careerhigh.backend.service;

import com.careerhigh.backend.dto.ClientDto;
import com.careerhigh.backend.persist.entity.Client;
import com.careerhigh.backend.persist.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    // 회원가입
    @Transactional
    public ClientDto signup(String email, String password, String name, String phoneNumber, String companyName, String managerName, String managerPhone) {
        Client client = Client.builder()
                .email(email)
                .encryptedPwd(password)
                .name(name)
                .phoneNumber(phoneNumber)
                .companyName(companyName)
                .managerName(managerName)
                .managerPhone(managerPhone)
                .starRating(0.0)
                .build();

        return ClientDto.fromEntity(clientRepository.save(client));
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