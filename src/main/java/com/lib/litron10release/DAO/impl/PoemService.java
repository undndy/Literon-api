package com.lib.litron10release.DAO.impl;

import com.lib.litron10release.DAO.PoemDAO;
import com.lib.litron10release.entity.Author;
import com.lib.litron10release.entity.Poem;
import com.lib.litron10release.repository.AuthorRepository;
import com.lib.litron10release.repository.PoemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class PoemService implements PoemDAO {

    @Autowired
    private PoemRepository poemRepository;

    @Override
    public List<Poem> getAll() {
        return poemRepository.findAll();
    }

    @Override
    public List<Poem> search(String searchString) {
        return poemRepository.searchPoem(searchString);
    }

    @Override
    public Poem get(long id) {
        Optional<Poem> bookmark = poemRepository.findById(id);
        return bookmark.orElse(null);
    }

    @Override
    public Poem save(Poem poem) {
        return poemRepository.save(poem);
    }

    @Override
    public void delete(Poem poem) {
        poemRepository.delete(poem);
    }

    @Override
    public List<Poem> getAll(Sort sort) {
        return poemRepository.findAll(sort);
    }

    public List<Poem> getPoemsByAuthor(Author authorId) {
        return poemRepository.findPoemsByAuthor(authorId);
    }
}
