package org.fasttrackit.nationsmatch.web;

import org.fasttrackit.nationsmatch.domain.Conversation;
import org.fasttrackit.nationsmatch.service.ConversationService;
import org.fasttrackit.nationsmatch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final UserService userService;
    private final ConversationService conversationService;

    @Autowired
    public ChatController(UserService userService, ConversationService conversationService) {
        this.userService = userService;
        this.conversationService = conversationService;
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Conversation conversation(@Payload Conversation conversation) {
        return conversation;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public Conversation addUser(@Payload Conversation conversation, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", conversation.getSender());
        return conversation;
    }
}
