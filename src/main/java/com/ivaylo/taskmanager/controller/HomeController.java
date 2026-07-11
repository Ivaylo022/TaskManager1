package com.ivaylo.taskmanager.controller;

import com.ivaylo.taskmanager.entity.Task;
import org.springframework.ui.Model;
import com.ivaylo.taskmanager.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "index";
    }

    private final TaskService taskService;

    public HomeController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks-page")
    public String tasksPage(Model model) {

        model.addAttribute(
                "tasks",
                taskService.getAllTasks());

        return "tasks";
    }

    @GetMapping("/add-task")
    public String addTaskPage(Model model) {

        model.addAttribute("task", new Task());

        return "add-task";
    }

    @GetMapping("/edit-task")
    public String editTaskPage() {
        return "edit-task";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
