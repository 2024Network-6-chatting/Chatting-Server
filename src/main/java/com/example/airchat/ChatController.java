package com.example.airchat;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ChatController {

    private final ObjectMapper objectMapper = new ObjectMapper(); // ObjectMapper를 사용하여 JSON을 객체로 변환

    @MessageMapping("/chat")
    @SendTo("/sub/chat")
    public Map<String, Object> handleChatMessage(String message) {
        try {
            // 받은 메시지를 JSON 객체로 변환
            Map<String, Object> messageMap = objectMapper.readValue(message, Map.class);

            // "긴급" 또는 "SOS" 단어가 포함되어 있는지 확인
            String content = (String) messageMap.get("content");
            boolean isEmergency = content.contains("긴급") || content.contains("SOS");

            // isEmergency만 수정
            messageMap.put("isEmergency", isEmergency);

            // 수정된 메시지 반환
            System.out.println("Response message: " + messageMap);
            return messageMap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}