package com.lib.litron10release.controller;

import com.lib.litron10release.DAO.impl.PoemService;
import com.lib.litron10release.DAO.impl.TaskService;
import com.lib.litron10release.DAO.impl.UserService;
import com.lib.litron10release.entity.Poem;
import com.lib.litron10release.entity.Task;
import com.lib.litron10release.entity.UserLiter;
import com.lib.litron10release.repository.PoemRepository;
import com.lib.litron10release.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private PoemService poemService;

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<Task>> getAllTaskForm() {
        return new ResponseEntity<>(taskService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{poemId}/{userId}")
    public ResponseEntity<List<Task>> getTaskForm(@PathVariable("poemId") Long poemId,
                                                  @PathVariable("userId") Long userId) {
        Poem poem = poemService.get(poemId);
        UserLiter user = userService.getUserById(userId);
        return new ResponseEntity<>(taskService.getTaskForPoem(poem, user), HttpStatus.OK);
    }

    @PostMapping("/create/{poemId}/{userId}")
    public ResponseEntity<List<Task>> createTasks(@RequestBody List<Task> tasks,
                                  @PathVariable("poemId") Long poemId,
                                  @PathVariable("userId") Long userId) {
        Poem poem = poemService.get(poemId);
        UserLiter user = userService.getUserById(userId);
        List<Task> savedTasks = new ArrayList<>();
        for (Task task : tasks) {
            task.setPoem(poem);
            task.setUserLiter(user);
            savedTasks.add(taskService.save(task));
        }
        return new ResponseEntity<>(savedTasks, HttpStatus.OK);
    }
//    @PostMapping("/create/{poemId}")
//    public Task createTask(@RequestBody Task task,
//                           @PathVariable("poemId") Long poemId) {
//        Poem poem = poemService.get(poemId);
//        task.setPoem(poem);
//        return taskService.save(task);
//    }

    @PostMapping("/user")
    public ResponseEntity<List<Task>> getTasksForCurrentUser(@RequestBody UserLiter user){
        return new ResponseEntity<>(taskService.getTaskForUser(user), HttpStatus.OK);
    }

//    @PostMapping("/{poemId}/create")
//    public Task createTask(@RequestBody Task task, @PathVariable("poemId") Long poemId) {
//        return taskService.saveTask(task, poemId);
//    }
}
