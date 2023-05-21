package com.lib.litron10release.DAO.impl;

import com.lib.litron10release.DAO.ChronoDAO;
import com.lib.litron10release.DAO.PoemDAO;
import com.lib.litron10release.entity.Author;
import com.lib.litron10release.entity.Chronograph;
import com.lib.litron10release.entity.Poem;
import com.lib.litron10release.repository.ChronoRepository;
import com.lib.litron10release.repository.PoemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChronoService implements ChronoDAO {

    @Autowired
    private ChronoRepository chronoRepository;

    @Override
    public List<Chronograph> getAll() {
        return chronoRepository.findAll();
    }

    @Override
    public List<Chronograph> search(String searchString) {
        return null;
    }

    @Override
    public Chronograph get(Long id) {
        Optional<Chronograph> bookmark = chronoRepository.findById(id);
        return bookmark.orElse(null);
    }

    @Override
    public Chronograph save(Chronograph chronograph) {
        return chronoRepository.save(chronograph);
    }

    @Override
    public void delete(Chronograph chronograph) {
        chronoRepository.delete(chronograph);
    }

    @Override
    public List<Chronograph> getAll(Sort sort) {
        return chronoRepository.findAll(sort);
    }

    public List<Chronograph> getChronoByAuthor(Author author){
        return chronoRepository.findChronographByAuthor(author);
    }
}
