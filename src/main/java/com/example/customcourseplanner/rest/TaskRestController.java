package com.example.customcourseplanner.rest;

import com.example.customcourseplanner.model.Task;
import com.example.customcourseplanner.service.TaskServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class TaskRestController {
    private final TaskServiceImpl taskService;

    public TaskRestController(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    List<Task> getAll() {
        return taskService.getAllTasks();
    }
}
