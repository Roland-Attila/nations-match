package org.fasttrackit.nationsmatch.persistance;

import org.fasttrackit.nationsmatch.domain.UserConversation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserConversationRepository extends JpaRepository<UserConversation, Long> {

    List<UserConversation> findByConversationUserLastName(String partialLastName);
}
