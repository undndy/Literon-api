package com.lib.litron10release.repository;

import com.lib.litron10release.entity.UserLiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserLiter, Long> {
    Optional<UserLiter> findUserById(Long id);

    Optional<UserLiter> findUserLiterByLastName(String lastName);

    Optional<UserLiter> findUserLiterByEmail(String email);

    @Query("SELECT p FROM UserLiter p WHERE " +
            "p.firstName LIKE CONCAT('%', :query, '%') OR p.lastName LIKE CONCAT('%', :query, '%') OR p.email LIKE CONCAT('%', :query, '%') ")
    List<UserLiter> searchUser(String query);

    List<UserLiter> findByLastNameContainingIgnoreCaseOrFirstNameContainingIgnoreCase(String firstName, String lastName);
}
