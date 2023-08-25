package com.lib.litron10release.controller;

import com.lib.litron10release.DAO.impl.BookService;
import com.lib.litron10release.entity.Book;
import com.lib.litron10release.entity.FileItem;
import com.lib.litron10release.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
@RequestMapping("api/content")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/{id}")
    private ResponseEntity<?> getImageById(@PathVariable("id") Long id){
        Book book = bookRepository.findById(id).orElse(null);
        return ResponseEntity.ok().header("bookName", book.getName())
                .contentType(MediaType.valueOf(book.getContentType()))
                .body(new InputStreamResource(new ByteArrayInputStream(book.getImageBytes())));
    }

    @PostMapping("/book")
    private ResponseEntity<?> uploadState(@RequestParam("book") MultipartFile book) throws IOException {
        return ResponseEntity.ok(bookService.save(book));
    }

    @GetMapping("/all")
    private ResponseEntity<?> getAllFile(){
        return ResponseEntity.ok(bookService.getAllBook());
    }
}
