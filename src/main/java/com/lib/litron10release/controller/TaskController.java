package com.lib.litron10release.controller;

import com.lib.litron10release.DAO.impl.TaskService;
import com.lib.litron10release.entity.Poem;
import com.lib.litron10release.entity.Task;
import com.lib.litron10release.repository.PoemRepository;
import com.lib.litron10release.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@CrossOrigin(origins = "http://localhost:4200/")
@Controller
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private PoemRepository poemRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskService taskService;

//    @GetMapping("/{poemId}/create")
//    public String createTaskForm(@PathVariable Long poemId) {
//        Poem poem = poemRepository.findById(poemId)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found"));
//
//    }
//
//    @PostMapping("/{poemId}/create")
//    public Task createTask(@PathVariable Long poemId, @RequestBody Task task) {
//        Poem poem = poemRepository.findById(poemId).orElseThrow(() -> new ResourceNotFoundException("Poem", "id", poemId));
//        task.setPoem(poem);
//        return taskRepository.save(task);
//    }
//
//    @PostMapping("/{poemId}/create")
//    public String createTask(@PathVariable Long poemId, @ModelAttribute Task task) {
//        Poem poem = poemRepository.findById(poemId)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Poem not found"));
//        task.setPoem(poem);
//        taskRepository.save(task);
//        return "redirect:/api/poems/" + poemId;
//    }

//    @PostMapping("/{poemId}/create")
//    public Task createTask(@PathVariable Long poemId, @RequestBody Task task) {
//        return taskService.createTask(poemId, task);
//    }
}
