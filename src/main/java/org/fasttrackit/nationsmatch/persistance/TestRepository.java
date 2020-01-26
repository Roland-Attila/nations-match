package org.fasttrackit.nationsmatch.persistance;

import org.fasttrackit.nationsmatch.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestRepository extends JpaRepository<Test, Long> {

    Optional<Test> findAllById(long id);
}
