package org.fasttrackit.nationsmatch.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fasttrackit.nationsmatch.domain.Conversation;
import org.fasttrackit.nationsmatch.exeption.ResourceNotFoundException;
import org.fasttrackit.nationsmatch.persistance.AnotherUserRepository;
import org.fasttrackit.nationsmatch.persistance.ConversationRepository;
import org.fasttrackit.nationsmatch.persistance.UserConversationRepository;
import org.fasttrackit.nationsmatch.transfer.AnotherUserRequest;
import org.fasttrackit.nationsmatch.transfer.SaveConversationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConversationRepository.class);
    private final ConversationRepository conversationRepository;
    private final UserConversationRepository userConversationRepository;
    private final AnotherUserRepository anotherUserRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public ConversationService(ConversationRepository conversationRepository, UserService userService,
                               UserConversationRepository userConversationRepository,
                               AnotherUserRepository anotherUserRepository, ObjectMapper objectMapper) {
        this.conversationRepository = conversationRepository;
        this.userConversationRepository = userConversationRepository;
        this.anotherUserRepository = anotherUserRepository;
        this.objectMapper = objectMapper;
    }

    public Conversation createConversation(SaveConversationRequest request) {
        LOGGER.info("Creating conversation {}", request);
        Conversation conversation = objectMapper.convertValue(request, Conversation.class);
        return conversationRepository.save(conversation);
    }

    public Conversation getConversation(long id) {
        LOGGER.info("Retrieving conversation {}", id);
        return conversationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException
                ("Conversation " + id + " does not exist."));
    }

    public Conversation getConversationWithAnotherUser(AnotherUserRequest request) {
        LOGGER.info("Retrieving conversation with user {}", request);
         return conversationRepository.findByUserLastName(request.getLastName()).
                 orElseThrow(() -> new ResourceNotFoundException("User with name "
                + request.getLastName() + " does not exist."));
    }

    public Conversation updateConversation(long id, SaveConversationRequest request) {
        LOGGER.info("Updating conversation {}: {}", id, request);
        Conversation conversation = getConversation(id);
        BeanUtils.copyProperties(request, conversation);
        return conversationRepository.save(conversation);
    }

    public void deleteConversation(long id) {
        LOGGER.info("Deleting conversation {}", id);
        conversationRepository.deleteById(id);
        LOGGER.info("Deleted conversation {}", id);
    }
}
