package com.ivaylo.taskmanager.controller;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import com.ivaylo.taskmanager.entity.Category;
import com.ivaylo.taskmanager.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import java.util.UUID;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public String categories(Model model) {

        model.addAttribute("category", new Category());

        model.addAttribute(
                "categories",
                categoryService.getAll());

        return "categories";
    }

    @PostMapping("/categories")
    public String addCategory(@Valid Category category,
                              BindingResult bindingResult,
                              Model model) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("categories", categoryService.getAll());

            return "categories";
        }

        categoryService.save(category);

        return "redirect:/categories";
    }

    @PostMapping("/categories/delete/{id}")
    public String deleteCategory(@PathVariable UUID id) {

        categoryService.deleteById(id);

        return "redirect:/categories";
    }
}
