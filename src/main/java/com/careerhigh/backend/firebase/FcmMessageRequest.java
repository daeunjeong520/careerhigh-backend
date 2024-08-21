package com.careerhigh.backend.firebase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FcmMessageRequest {

    private Long userId; // 유저 ID

    private String title; // 메세지 제목

    private String body; // 메세지 내용
}
