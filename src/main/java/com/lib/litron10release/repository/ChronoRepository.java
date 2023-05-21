package com.lib.litron10release.repository;

import com.lib.litron10release.entity.Author;
import com.lib.litron10release.entity.Poem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

//@CrossOrigin("http://localhost:4200")
@Repository
@Projection(types={Poem.class})
public interface PoemRepository extends JpaRepository<Poem, Long> {

    List<Poem>findPoemsByAuthor(Author author);

    @Query("SELECT p FROM Poem p WHERE p.namePoem LIKE CONCAT('%', :query, '%')")
    List<Poem> searchPoem(String query);
}
