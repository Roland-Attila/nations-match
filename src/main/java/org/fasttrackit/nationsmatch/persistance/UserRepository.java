package org.fasttrackit.nationsmatch.persistance;

import org.fasttrackit.nationsmatch.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
