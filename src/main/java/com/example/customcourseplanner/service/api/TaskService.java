package com.example.customcourseplanner.service.api;

import com.example.customcourseplanner.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task addTask(Task task);
    void deleteTaskById(long id);
    Optional<Task> getTaskById(long id);
    Task editTask(Task task);
    List<Task> getAllTasks();
}
