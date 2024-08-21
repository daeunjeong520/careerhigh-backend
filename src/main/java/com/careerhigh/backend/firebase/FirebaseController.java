package com.careerhigh.backend.firebase;

import com.google.firebase.messaging.FirebaseMessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FirebaseController {

    private final FirebaseMessageService firebaseMessageService;

    @PostMapping("/api/v1/fcm/sendMessageToFreelancer")
    public ResponseEntity<String> sendMessageToFreelancer(@RequestBody FcmMessageRequest fcmMessageRequest) throws FirebaseMessagingException {
        String response = firebaseMessageService.sendMessageToFreelancer(
                fcmMessageRequest.getUserId(),
                fcmMessageRequest.getTitle(),
                fcmMessageRequest.getBody()
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping("/api/v1/fcm/sendMessageToClient")
    public ResponseEntity<String> sendMessageToClient(@RequestBody FcmMessageRequest fcmMessageRequest) throws FirebaseMessagingException {
        String response = firebaseMessageService.sendMessageToClient(
                fcmMessageRequest.getUserId(),
                fcmMessageRequest.getTitle(),
                fcmMessageRequest.getBody()
        );
        return ResponseEntity.ok(response);
    }
}
