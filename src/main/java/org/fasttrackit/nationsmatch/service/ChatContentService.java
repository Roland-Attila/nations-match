package org.fasttrackit.nationsmatch.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fasttrackit.nationsmatch.domain.ChatContent;
import org.fasttrackit.nationsmatch.exeption.ResourceNotFoundException;
import org.fasttrackit.nationsmatch.persistance.ChatContentRepository;
import org.fasttrackit.nationsmatch.transfer.ChatContentRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ChatContentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChatContentService.class);
    private final ChatContentRepository chatContentRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public ChatContentService(ChatContentRepository chatContentRepository, ObjectMapper objectMapper) {
        this.chatContentRepository = chatContentRepository;
        this.objectMapper = objectMapper;
    }

    public ChatContent createTest(ChatContentRequest request) {
        LOGGER.info("Creating chat");
        ChatContent chatContent = objectMapper.convertValue(request, ChatContent.class);
        return chatContentRepository.save(chatContent);
    }

    public ChatContent getChats(long id) {
        LOGGER.info("Retrieving chat {}", id);
        return chatContentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doesn't exist"));
    }

    public Page<ChatContent> getTests(Pageable pageable) {
        return chatContentRepository.findAll(pageable);
    }
}
