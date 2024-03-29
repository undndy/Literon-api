package com.lib.litron10release.DAO.impl;

import com.lib.litron10release.DAO.TaskDAO;
import com.lib.litron10release.entity.Poem;
import com.lib.litron10release.entity.Task;
import com.lib.litron10release.entity.UserLiter;
import com.lib.litron10release.repository.PoemRepository;
import com.lib.litron10release.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements TaskDAO {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> search(String searchString) {
        return null;
    }

    @Override
    public Task get(Long id) {
        return null;
    }

    @Override
    public Task save(Task task) {

        return taskRepository.save(task);
    }

//    public Task saveTask(Task task, Long poemId) {
//        Optional<Poem> poem = poemRepository.findById(poemId); // Получить объект Poem из репозитория
//        task.setPoem(poem); // Установить значение поля poem
//        return taskRepository.save(task);
//    }

    @Override
    public void delete(Task task) {
        taskRepository.delete(task);
    }

    @Override
    public List<Task> getAll(Sort sort) {
        return taskRepository.findAll(sort);
    }

    @Override
    public List<Task> findTopTasks(int limit) {
        return null;
    }

    public List<Task> getTaskForPoem(Poem poem, UserLiter user){
        return taskRepository.findTaskByPoemAndUserLiter(poem, user);
    }

    public List<Task> getTaskForUser(UserLiter user){
        return taskRepository.findTaskByUserLiter(user);
    }
}
