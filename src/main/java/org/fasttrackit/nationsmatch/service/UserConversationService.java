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
    private ConversationService conversationService;
    private UserService userService;

    public UserConversationService(UserConversationRepository userConversationRepository) {
        this.userConversationRepository = userConversationRepository;
    }

    public void addUserToConversation(SaveUserRequest request) {
        LOGGER.info("Adding user {}", request);
//        User user = userConversationRepository.findAll(request.get);
//        todo: ad user to conversation
    }
}
