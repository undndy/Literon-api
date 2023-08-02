package com.lib.litron10release.controller;

import com.lib.litron10release.DAO.impl.AuthorService;
import com.lib.litron10release.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("api/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/all")
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> authorList = authorService.getAll();
        return new ResponseEntity<>(authorList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable("id") long id) {
        return new ResponseEntity<>(authorService.get(id), HttpStatus.OK);
    }

    @GetMapping("/search")
    public List<Author> searchAuthorsAndPoems(
            @RequestParam(name = "authorName", required = false) String authorName,
            @RequestParam(name = "poemName", required = false) String poemName) {return authorService.searchAuthorsAndPoems(authorName,poemName);}

    @PostMapping("/create")
    public Author createAuthor(@RequestParam("image") MultipartFile image, @Valid @RequestBody Author author) throws IOException {
        return authorService.save(author, image);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Author> updateImage(@RequestParam("image") MultipartFile image, @PathVariable("id") Long id) throws IOException {
        return ResponseEntity.ok(authorService.updateImageByid(image, id));
    }

//    @DeleteMapping("/delete")
//    public ResponseEntity<Author> deleteAuthor(@ResponseBody Author author){
//        authorService.delete(author);
//        return new ResponseEntity<>(,HttpStatus.OK)
//    }
}
