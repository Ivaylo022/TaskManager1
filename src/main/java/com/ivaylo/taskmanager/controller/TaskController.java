package com.ivaylo.taskmanager.controller;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import com.ivaylo.taskmanager.entity.Task;
import com.ivaylo.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public String createTask(
            @Valid Task task,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("task", task);
            return "add-task";
        }

        taskService.createTask(task);

        return "redirect:/tasks-page";
    }

    @PostMapping("/edit/{id}")
    public String editTask(@PathVariable UUID id,
                           @Valid Task task,
                           BindingResult bindingResult,
                           Model model) {

        if (bindingResult.hasErrors()) {
            task.setId(id);
            model.addAttribute("task", task);
            return "edit-task";
        }

        task.setId(id);

        taskService.save(task);

        return "redirect:/tasks-page";
    }

    @PostMapping("/delete/{id}")
    public String deleteTaskFromPage(@PathVariable UUID id) {

        taskService.deleteTask(id);

        return "redirect:/tasks-page";
    }

    @PostMapping("/done/{id}")
    public String markDoneFromPage(@PathVariable UUID id) {

        Task task = taskService.getTaskById(id);

        task.setStatus("Done");

        taskService.save(task);

        return "redirect:/tasks-page";
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable UUID id) {
        taskService.deleteTask(id);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable UUID id,
                           @RequestBody Task task) {

        task.setId(id);

        return taskService.save(task);
    }

    @PutMapping("/{id}/done")
    public Task markDone(@PathVariable UUID id) {

        Task task = taskService.getTaskById(id);

        task.setStatus("Done");

        return taskService.save(task);
    }
}