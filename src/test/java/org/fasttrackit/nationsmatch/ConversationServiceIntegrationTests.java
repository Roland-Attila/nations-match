package org.fasttrackit.nationsmatch;

import org.fasttrackit.nationsmatch.domain.Conversation;
import org.fasttrackit.nationsmatch.service.ConversationService;
import org.fasttrackit.nationsmatch.transfer.ConversationRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

@SpringBootTest
public class ConversationServiceIntegrationTests {

    @Autowired
    private ConversationService conversationService;

    @Test
    void testCreateConversation_whenValidRequest_thanConversationIsSaved(){
        ConversationRequest request = new ConversationRequest();
        request.setUserFirstName("Lica");
        request.setUserLastName("Samadaul");
        request.setGroupName("Test");
        request.setMessageSentDate(LocalDate.now());
        request.setSeen(false);
        request.setSent(true);

        Conversation createdConversation = conversationService.createConversation(request);

        assertThat(createdConversation, notNullValue());
        assertThat(createdConversation.getId(), notNullValue());
        assertThat(createdConversation.getId(), greaterThan(0L));
        assertThat(createdConversation.getMessageSentDate(), is(request.getMessageSentDate()));
        assertThat(createdConversation.getGroupName(), is(request.getGroupName()));
        assertThat(createdConversation.getUserFirstName(), is(request.getUserFirstName()));
        assertThat(createdConversation.getUserLastName(), is(request.getUserLastName()));
        assertThat(createdConversation.isSeen(), is(request.isSeen()));
        assertThat(createdConversation.isSent(), is(request.isSent()));
    }
}
