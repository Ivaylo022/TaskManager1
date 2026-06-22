package com.ivaylo.taskmanager.controller;

import com.ivaylo.taskmanager.entity.Category;
import com.ivaylo.taskmanager.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public String categories(Model model) {

        model.addAttribute(
                "categories",
                categoryService.getAll());

        return "categories";
    }

    @PostMapping("/categories")
    public String addCategory(Category category) {

        categoryService.save(category);

        return "redirect:/categories";
    }
}
