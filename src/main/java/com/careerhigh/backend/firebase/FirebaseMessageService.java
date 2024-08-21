package com.careerhigh.backend.firebase;

import com.careerhigh.backend.persist.entity.Client;
import com.careerhigh.backend.persist.entity.Freelancer;
import com.careerhigh.backend.persist.repository.ClientRepository;
import com.careerhigh.backend.persist.repository.FreelancerRepository;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class FirebaseMessageService {

    private final FreelancerRepository freelancerRepository;
    private final ClientRepository clientRepository;

    // 사용자의 Firebase 토큰값을 조회
    public String sendMessageToFreelancer(Long freelancerId, String title, String content) throws FirebaseMessagingException {

        // 프리랜서 토큰 조회
        Freelancer freelancer = freelancerRepository.findById(freelancerId)
                .orElseThrow(() -> new RuntimeException("Not Found Freelancer"));

        String token = freelancer.getFcmToken();


        // 메세지 구성
        String message = FirebaseMessaging.getInstance().send(Message.builder()
                .setNotification(Notification.builder()
                        .setTitle(title)
                        .setBody(content)
                        .build())
                .setToken(token)
                .build());

        log.info("message={}", message.toString());

        return message;
    }

    public String sendMessageToClient(Long clientId, String title, String content) throws FirebaseMessagingException {

        // 프리랜서 토큰 조회
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Not Found Client"));

        String token = client.getFcmToken();


        // 메세지 구성
        String message = FirebaseMessaging.getInstance().send(Message.builder()
                .setNotification(Notification.builder()
                        .setTitle(title)
                        .setBody(content)
                        .build())
                .setToken(token)
                .build());

        log.info("message={}", message.toString());

        return message;
    }
}