package com.lib.litron10release.DAO.impl;

import com.lib.litron10release.entity.Book;
import com.lib.litron10release.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    private Book toFileEntity(MultipartFile image) throws IOException {
        Book book = new Book();
        book.setName(image.getName());
        book.setContentType(image.getContentType());
        book.setImageBytes(image.getBytes());
        book.setOriginalFileName(image.getOriginalFilename());
        return book;
    }

    public Book save(MultipartFile state) throws IOException {
        Book book = toFileEntity(state);
        return bookRepository.save(book);
    }

    @Transactional
    public List<Book> getAllBook(){
        return bookRepository.findAllByName("book");
    }
}
