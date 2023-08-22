package com.lib.litron10release.controller;

import com.lib.litron10release.DAO.impl.BookService;
import com.lib.litron10release.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/content")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/book")
    private ResponseEntity<?> uploadState(@RequestParam("book") MultipartFile book) throws IOException {
        return ResponseEntity.ok(bookService.save(book));
    }

    @GetMapping("/all")
    private ResponseEntity<?> getAllFile(){
        return ResponseEntity.ok(bookService.getAllBook());
    }
}
