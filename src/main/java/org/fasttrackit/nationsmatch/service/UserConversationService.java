package org.fasttrackit.nationsmatch.service;

import org.fasttrackit.nationsmatch.domain.UserConversation;
import org.fasttrackit.nationsmatch.persistance.UserConversationRepository;
import org.fasttrackit.nationsmatch.transfer.SaveUserRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserConversationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserConversation.class);
    private final UserConversationRepository userConversationRepository;
    private final ConversationService conversationService;
    private final UserService userService;

    public UserConversationService(UserConversationRepository userConversationRepository, ConversationService conversationService, UserService userService) {
        this.userConversationRepository = userConversationRepository;
        this.conversationService = conversationService;
        this.userService = userService;
    }

    public void createConversation(){}

    public void addUserToConversation(SaveUserRequest request) {
        LOGGER.info("Adding user {}", request);
//        User user = userConversationRepository.findAll(request.get);
//        todo: ad user to conversation
    }
}
