package com.lib.litron10release.repository;

import com.lib.litron10release.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findByLastNameContainingAndPoemsNamePoemContaining(String authorName, String poemName);

    List<Author> findByLastNameContaining(String authorName);

    List<Author> findByPoemsNamePoemContaining(String authorName);

    List<Author> findByLastNameContainingIgnoreCaseOrderByLastName(String lastname);

}
