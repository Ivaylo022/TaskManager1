package com.ivaylo.taskmanager.controller;

import jakarta.servlet.http.HttpSession;
import com.ivaylo.taskmanager.entity.User;
import com.ivaylo.taskmanager.entity.Task;
import java.util.UUID;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String tasksPage(Model model, HttpSession session) {

        if (session.getAttribute("userId") == null) {
            return "redirect:/login";
        }

        model.addAttribute(
                "tasks",
                taskService.getAllTasks());

        return "tasks";
    }

    @GetMapping("/add-task")
    public String addTaskPage(Model model, HttpSession session) {

        if (session.getAttribute("userId") == null) {
            return "redirect:/login";
        }

        model.addAttribute("task", new Task());

        return "add-task";
    }

    @GetMapping("/edit-task/{id}")
    public String editTaskPage(@PathVariable UUID id,
                               Model model,
                               HttpSession session) {

        if (session.getAttribute("userId") == null) {
            return "redirect:/login";
        }

        model.addAttribute(
                "task",
                taskService.getTaskById(id));

        return "edit-task";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    @GetMapping("/register")
    public String registerPage(Model model) {

        model.addAttribute("user", new User());

        return "register";
    }
}

