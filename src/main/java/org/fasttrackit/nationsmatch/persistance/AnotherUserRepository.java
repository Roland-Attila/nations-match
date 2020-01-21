package org.fasttrackit.nationsmatch.persistance;

import org.fasttrackit.nationsmatch.domain.AnotherUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnotherUserRepository extends JpaRepository<AnotherUser, Long> {
}
