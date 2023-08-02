package com.lib.litron10release.controller;

import com.lib.litron10release.DAO.impl.FileService;
import com.lib.litron10release.entity.Author;
import com.lib.litron10release.entity.FileItem;
import com.lib.litron10release.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
@RequestMapping("api/image")
public class FileController {
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private FileService fileService;

    @GetMapping("/{id}")
    private ResponseEntity<?> getImageById(@PathVariable("id") Long id){
        FileItem file = fileRepository.findById(id).orElse(null);
        return ResponseEntity.ok().header("fileName", file.getName())
                .contentType(MediaType.valueOf(file.getContentType()))
                .body(new InputStreamResource(new ByteArrayInputStream(file.getImageBytes())));
    }

    @PostMapping("/state")
    private ResponseEntity<?> uploadState(@RequestParam("state") MultipartFile state) throws IOException {
        return ResponseEntity.ok(fileService.save(state));
    }

    @GetMapping("/all")
    private ResponseEntity<?> getAllFile(){
        return ResponseEntity.ok(fileService.getAllState());
    }
}
