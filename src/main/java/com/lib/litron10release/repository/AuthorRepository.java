package com.lib.litron10release.repository;

import com.lib.litron10release.entity.Author;
import com.lib.litron10release.entity.Poem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findByLastNameContainingIgnoreCaseOrderByLastName(String lastname);

    @Query("SELECT a FROM Author a WHERE a.patronymic LIKE CONCAT('%', :query, '%')")
    List<Poem> searchAuthor(String query);


}
