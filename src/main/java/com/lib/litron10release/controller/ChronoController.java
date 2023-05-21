package com.lib.litron10release.controller;


import com.lib.litron10release.DAO.impl.ChronoService;
import com.lib.litron10release.entity.Author;
import com.lib.litron10release.entity.Chronograph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("api/chrono")
public class ChronoController {

    @Autowired
    private ChronoService chronoService;

    @GetMapping("/{id}")
    public ResponseEntity<Chronograph> getChronoById(@PathVariable Long id) {
        Chronograph chronograph = chronoService.get(id);
        return new ResponseEntity<>(chronograph, HttpStatus.OK);
    }

    @GetMapping("/{authorId}/chronograph")
    public ResponseEntity<List<Chronograph>> getChronoByAuthor(@PathVariable("authorId") Author authorId) {
        List<Chronograph> chronographList =chronoService.getChronoByAuthor(authorId);
        return new ResponseEntity<>(chronographList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Chronograph> createChronograph(@RequestBody Chronograph chronograph){
        Chronograph createdChronograph = chronoService.save(chronograph);
        return new ResponseEntity<>(createdChronograph, HttpStatus.OK);
    }
}
