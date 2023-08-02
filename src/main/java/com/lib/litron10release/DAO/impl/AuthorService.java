package com.lib.litron10release.DAO.impl;

import com.lib.litron10release.DAO.AuthorDAO;
import com.lib.litron10release.entity.Author;
import com.lib.litron10release.entity.FileItem;
import com.lib.litron10release.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements AuthorDAO {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public List<Author> search(String searchString) {
        return authorRepository.findByLastNameContainingIgnoreCaseOrderByLastName(searchString);
    }

    @Override
    public Author get(Long id) {
        Optional<Author> bookmark = authorRepository.findById(id);
        return bookmark.orElse(null);
    }

    @Override
    public Author save(Author obj) {
        return null;
    }

    @Override
    public Author save(Author author, MultipartFile image) throws IOException {
        FileItem file;
        if (image.getSize() != 0){
            file = toFileEntity(image);
            author.setImage(file);
        }
        return authorRepository.save(author);
    }

    private FileItem toFileEntity(MultipartFile image) throws IOException {
        FileItem fileItem = new FileItem();
        fileItem.setName(image.getName());
        fileItem.setContentType(image.getContentType());
        fileItem.setImageBytes(image.getBytes());
        fileItem.setOriginalFileName(image.getOriginalFilename());
        return fileItem;
    }

    private FileItem toFileEntity(MultipartFile image, Long id) throws IOException {
        FileItem fileItem = new FileItem();
        Author author = authorRepository.findById(id).orElse(null);
        fileItem.setName(image.getName());
        fileItem.setContentType(image.getContentType());
        fileItem.setImageBytes(image.getBytes());
        fileItem.setOriginalFileName(image.getOriginalFilename());
        fileItem.setAuthor(author);
        return fileItem;
    }

    @Override
    public void delete(Author author) {
        authorRepository.delete(author);
    }

    @Override
    public List<Author> getAll(Sort sort) {
        return authorRepository.findAll(sort);
    }


    //????
    public List<Author> searchAuthorsAndPoems(
            @RequestParam(name = "authorName", required = false) String authorName,
            @RequestParam(name = "poemName", required = false) String poemName) {

        if (authorName != null && poemName != null) {
            // Search for authors and their poems by author name and poem name
            return authorRepository.findByLastNameContainingAndPoemsNamePoemContaining(authorName, poemName);
        } else if (authorName != null) {
            // Search for authors by author name
            return authorRepository.findByLastNameContaining(authorName);
        } else if (poemName != null) {
            // Search for authors and their poems by poem name
            return authorRepository.findByPoemsNamePoemContaining(poemName);
        } else {
            // If no search parameters are provided, return all authors with their poems
            return authorRepository.findAll();
        }
    }

    public Author updateImageByid(MultipartFile image, Long authorId) throws IOException {
        FileItem file;
        Author author = authorRepository.findById(authorId).orElse(null);
        if (image.getSize() != 0){
            file = toFileEntity(image, authorId);
            assert author != null;
            author.setImage(file);
        }
        assert author != null;
        return authorRepository.save(author);
    }
}
