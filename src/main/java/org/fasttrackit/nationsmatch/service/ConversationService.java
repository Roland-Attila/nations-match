package org.fasttrackit.nationsmatch.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fasttrackit.nationsmatch.domain.Conversation;
import org.fasttrackit.nationsmatch.persistance.ConversationRepository;
import org.fasttrackit.nationsmatch.transfer.SaveConversationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConversationRepository.class);
    private final ConversationRepository conversationRepository;
    private final ObjectMapper objectMapper;
    private SaveConversationRequest saveConversationRequest;
    private UserService userService;

    @Autowired
    public ConversationService(ConversationRepository conversationRepository, ObjectMapper objectMapper) {
        this.conversationRepository = conversationRepository;
        this.objectMapper = objectMapper;
    }

    public Conversation createConversation(SaveConversationRequest request) {
        LOGGER.info("Creating conversation {}", request);
        Conversation conversation = objectMapper.convertValue(request, Conversation.class);
        return conversationRepository.save(conversation);
    }
}
