package org.fasttrackit.nationsmatch.persistance;

import org.fasttrackit.nationsmatch.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findByFirstNameAndLastName(String partialFirstName, String partialLastName, Pageable pageable);

    Page<User> findByAgeBetweenAndNationalityMatchesRegex(int age, int ageBetween, String sameNationality,Pageable pageable);
}
