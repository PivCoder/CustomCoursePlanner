package com.example.customcourseplanner.service;

import com.example.customcourseplanner.model.Task;
import com.example.customcourseplanner.repositoryes.TaskRepository;
import com.example.customcourseplanner.service.api.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTaskById(long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Optional<Task> getTaskById(long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task editTask(Task newTask, long id) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setStartDate(newTask.getStartDate());
                    task.setName(newTask.getName());
                    task.setCourse(newTask.getCourse());
                    task.setEndDate(newTask.getEndDate());
                    task.setFileLink(newTask.getFileLink());
                    task.setDone(newTask.isDone());
                    return taskRepository.save(task);
                })
                .orElseGet(() -> taskRepository.save(newTask));
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}
