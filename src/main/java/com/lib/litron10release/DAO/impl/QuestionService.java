package com.lib.litron10release.DAO.impl;

import com.lib.litron10release.DAO.QuestionDAO;
import com.lib.litron10release.entity.Question;
import com.lib.litron10release.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService implements QuestionDAO {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> search(String searchString) {
        return null;
    }

    @Override
    public Question get(long id) {
        return null;
    }

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public void delete(Question question) {
        questionRepository.delete(question);
    }

    @Override
    public List<Question> getAll(Sort sort) {
        return questionRepository.findAll(sort);
    }
}
