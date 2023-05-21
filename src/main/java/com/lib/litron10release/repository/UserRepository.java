package com.lib.litron10release.repository;

import com.lib.litron10release.entity.UserLiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserLiter, Long> {
    Optional<UserLiter> findUserById(Long id);

    Optional<UserLiter> findUserLiterByLastName(String lastName);

    Optional<UserLiter> findUserLiterByEmail(String email);
}
