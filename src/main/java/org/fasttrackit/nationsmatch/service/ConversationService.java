package org.fasttrackit.nationsmatch.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fasttrackit.nationsmatch.domain.Conversation;
import org.fasttrackit.nationsmatch.persistance.ConversationRepository;
import org.fasttrackit.nationsmatch.transfer.ConversationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConversationRepository.class);
    private final ConversationRepository conversationRepository;
    private final ObjectMapper objectMapper;
    private ConversationRequest conversationRequest;
    private UserService userService;

    @Autowired
    public ConversationService(ConversationRepository conversationRepository, ObjectMapper objectMapper) {
        this.conversationRepository = conversationRepository;
        this.objectMapper = objectMapper;
    }

    public Conversation createConversation(ConversationRequest conversationRequest) {
        LOGGER.info("Creating conversation {}", conversationRequest);
        Conversation conversation = objectMapper.convertValue(conversationRequest, Conversation.class);
        return conversationRepository.save(conversation);
    }
}
