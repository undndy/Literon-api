package com.lib.litron10release.controller;


import com.lib.litron10release.DAO.PoemDAO;
import com.lib.litron10release.DAO.impl.PoemService;
import com.lib.litron10release.entity.Author;
import com.lib.litron10release.entity.Poem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/poems")
public class PoemController {

    @Autowired
    private PoemService poemService;

    @GetMapping("/all")
    public List<Poem> getAllPoems() {
        return poemService.getAll();
    }

    @GetMapping("/{id}")
    public Poem getPoemById(@PathVariable Long id) {
        return poemService.get(id);
    }

    @GetMapping("/authors/{authorId}/poems")
    public List<Poem> getPoemsByAuthor(@RequestBody Poem poems, @PathVariable Author authorId) {
        return poemService.getPoemsByAuthor(authorId);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Poem>> find(@RequestParam("query") String query) {
        return ResponseEntity.ok(poemService.search(query));
    }
}
