package org.fasttrackit.nationsmatch.service;

import org.fasttrackit.nationsmatch.persistance.ConversationRepository;
import org.fasttrackit.nationsmatch.transfer.ConversationHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConversationRepository.class);

    private final ConversationRepository conversationRepository;
    private ConversationHandler conversationHandler;
    private UserService userService;


    @Autowired
    public ConversationService(ConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }

//    public List<User> createUser(ConversationHandler conversationHandler){
//        User user;
//    }
}
