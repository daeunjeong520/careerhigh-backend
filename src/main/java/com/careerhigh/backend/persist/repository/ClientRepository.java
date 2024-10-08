package com.careerhigh.backend.persist.repository;

import com.careerhigh.backend.persist.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByEmail(String email);

    Optional<Client> findByNaverToken(String naverToken);
    Optional<Client> findByGoogleToken(String googleToken);
    Optional<Client> findByKakaoToken(String kakaoToken);
}