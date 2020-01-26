package org.fasttrackit.nationsmatch.persistance;

import org.fasttrackit.nationsmatch.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
