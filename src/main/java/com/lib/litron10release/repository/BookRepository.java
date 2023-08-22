package com.lib.litron10release.repository;

import com.lib.litron10release.entity.Book;
import com.lib.litron10release.entity.FileItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByName(String state);

}
