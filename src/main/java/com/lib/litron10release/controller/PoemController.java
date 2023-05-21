package com.lib.litron10release.controller;


import com.lib.litron10release.DAO.impl.PoemService;
import com.lib.litron10release.entity.Author;
import com.lib.litron10release.entity.Poem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("api/poems")
public class PoemController {

    @Autowired
    private PoemService poemService;

    @GetMapping("/all")
    public ResponseEntity<List<Poem>> getAllPoems() {
        List<Poem> poemList = poemService.getAll();
        return new ResponseEntity<>(poemList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Poem> getPoemById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(poemService.get(id), HttpStatus.OK);
    }

    @GetMapping("/authors/{authorId}/poems")
    public ResponseEntity<List<Poem>> getPoemsByAuthor(@PathVariable("authorId") Author authorId) {
        List<Poem> poemList = poemService.getPoemsByAuthor(authorId);
        return new ResponseEntity<>(poemList, HttpStatus.OK);
    }

//    ????
    @GetMapping("/search")
    public ResponseEntity<List<Poem>> find(@RequestParam("query") String query) {
        return ResponseEntity.ok(poemService.search(query));
    }

    @PostMapping("/create")
    public Poem createPoem(@Valid @RequestBody Poem poem){
        return poemService.save(poem);
    }
}
