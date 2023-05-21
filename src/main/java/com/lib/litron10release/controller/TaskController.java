package com.lib.litron10release.controller;

import com.lib.litron10release.DAO.impl.PoemService;
import com.lib.litron10release.DAO.impl.TaskService;
import com.lib.litron10release.entity.Poem;
import com.lib.litron10release.entity.Task;
import com.lib.litron10release.repository.PoemRepository;
import com.lib.litron10release.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private PoemService poemService;

    @GetMapping("/all")
    public ResponseEntity<List<Task>> getAllTaskForm() {
        return new ResponseEntity<>(taskService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{poemId}")
    public ResponseEntity<List<Task>> getTaskForm(@PathVariable("poemId") Long poemId) {
        Poem poem = poemService.get(poemId);
        return new ResponseEntity<>(taskService.getTaskForPoem(poem), HttpStatus.OK);
    }

    @PostMapping("/create")
    public Task createTask(@RequestBody Task task) {
        return taskService.save(task);
    }

//    @PostMapping("/{poemId}/create")
//    public Task createTask(@RequestBody Task task, @PathVariable("poemId") Long poemId) {
//        return taskService.saveTask(task, poemId);
//    }
}
