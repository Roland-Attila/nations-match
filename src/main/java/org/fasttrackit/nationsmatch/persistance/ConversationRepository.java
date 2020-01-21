package org.fasttrackit.nationsmatch.persistance;

import org.fasttrackit.nationsmatch.domain.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConversationRepository extends JpaRepository<Conversation, Long> {

    Optional<Conversation> findByUserLastName(String partialLastName);
}
