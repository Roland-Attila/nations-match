package org.fasttrackit.nationsmatch.web;

import org.fasttrackit.nationsmatch.domain.Conversation;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Conversation conversation(@Payload Conversation conversation) {
        return conversation;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public Conversation addUser(@Payload Conversation conversation, SimpMessageHeaderAccessor headerAccessor, String userLastName) {
        headerAccessor.getSessionAttributes().put("username", conversation.getSender());
        return conversation;
    }
}
