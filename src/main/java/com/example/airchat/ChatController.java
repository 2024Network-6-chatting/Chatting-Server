package com.example.airchat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/*
@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/message/{sender}/{receiver}")  // sender와 receiver를 포함한 메시지 경로
    public void sendMessage(String message, @DestinationVariable String sender, @DestinationVariable String receiver) {
        // 받은 메시지를 receiver에게 직접 전달
        String destination = "/user/" + receiver + "/queue/messages";  // 메시지를 받을 사용자에게 보내는 경로
        messagingTemplate.convertAndSendToUser(receiver, destination, sender + "님으로부터: " + message);
    }
}
*/