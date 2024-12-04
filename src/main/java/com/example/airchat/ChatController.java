package com.example.airchat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class ChatController {

    // 클라이언트가 "/pub/chat"로 메시지를 보낼 때 호출됨
    @MessageMapping("/chat")
    @SendTo("/sub/chat")  // 모든 구독자에게 메시지를 전달
    public String handleChatMessage(String message) {
        System.out.println("Received message: " + message);  // 로그 추가
        return message;  // 받은 메시지를 그대로 반환 (구독자에게 전송)
    }
}