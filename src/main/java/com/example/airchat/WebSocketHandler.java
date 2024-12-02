package com.example.airchat;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

@Component
public class WebSocketHandler extends TextWebSocketHandler {

    private final static Logger LOG = Logger.getGlobal();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String input = message.getPayload();
        LOG.info(input); // 채팅 log
        TextMessage textMessage = new TextMessage("Success!");
        session.sendMessage(textMessage);
    }
}