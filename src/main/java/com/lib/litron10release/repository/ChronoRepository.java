package com.lib.litron10release.repository;

import com.lib.litron10release.entity.Author;
import com.lib.litron10release.entity.Chronograph;
import com.lib.litron10release.entity.Poem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.stereotype.Repository;

import java.util.List;

//@CrossOrigin("http://localhost:4200")
@Repository
@Projection(types={Poem.class})
public interface ChronoRepository extends JpaRepository<Chronograph, Long> {

    List<Chronograph> findChronographByAuthor(Author author);

}
