package org.fasttrackit.nationsmatch.web;

import org.fasttrackit.nationsmatch.domain.Conversation;
import org.fasttrackit.nationsmatch.service.ConversationService;
import org.fasttrackit.nationsmatch.transfer.AnotherUserRequest;
import org.fasttrackit.nationsmatch.transfer.SaveConversationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/conversation")
public class ConversationController {

    private final ConversationService conversationService;

    @Autowired
    public ConversationController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @PostMapping
    public ResponseEntity<Conversation> createConversation(@RequestBody @Valid SaveConversationRequest request) {
        Conversation conversation = conversationService.createConversation(request);
        return new ResponseEntity<>(conversation, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conversation> getConversation(@PathVariable("id") Long id) {
        Conversation conversation = conversationService.getConversation(id);
        return new ResponseEntity<>(conversation, HttpStatus.OK);
    }

    @GetMapping("/another-user")
    public ResponseEntity<Conversation> getConversationWithAnotherUser(AnotherUserRequest request){
        Conversation conversation = conversationService.getConversationWithAnotherUser(request);
        return new ResponseEntity<>(conversation, HttpStatus.OK);
    }

    @GetMapping("/home")
    public String basicConversation() {
        return "hello conversation";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/admin/all")
    public String adminLogin() {
        return "hello admin";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conversation> updateConversation(@PathVariable("id") Long id, @RequestBody @Valid SaveConversationRequest request) {
        Conversation conversation = conversationService.updateConversation(id, request);
        return new ResponseEntity<>(conversation, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteConversation(@PathVariable("id") Long id) {
        conversationService.deleteConversation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
