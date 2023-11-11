package com.example.customcourseplanner.controllers;

import com.example.customcourseplanner.model.Task;
import com.example.customcourseplanner.service.TaskServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class TaskController {
    private final TaskServiceImpl taskService;

    public TaskController(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public String showTasks(Model model) {
        List<Task> taskList = taskService.getAllTasks();
        model.addAttribute("taskList", taskList);
        return "tasks";
    }

    @GetMapping("/tasks/{id}")
    public String showTask(@PathVariable("id") long id, Model model) {
        Optional<Task> task = taskService.getTaskById(id);
        List<Task> taskList = new ArrayList<>();
        task.ifPresent(taskList::add);
        model.addAttribute("taskList", taskList);
        return "tasks";
    }

    @GetMapping("/new_task")
    public String addTask() {
        return "/newTask";
    }

    @PostMapping("/new_task")
    public String taskPostAdd(@ModelAttribute Task task) {
        taskService.addTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/{id}/edit")
    public String editTask(@PathVariable("id") long id, Model model) {
        Optional<Task> task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "editTask";
    }

    @PostMapping("/tasks/{id}/edit")
    public String taskPostEdit(@PathVariable("id") long id, @ModelAttribute Task updatedTask) {
        taskService.editTask(updatedTask, id);
        return "redirect:/tasks";
    }

    @PostMapping("/tasks/{id}/delete")
    public String taskPostDelete(@PathVariable long id) {
        taskService.deleteTaskById(id);
        return "redirect:/tasks";
    }
}
