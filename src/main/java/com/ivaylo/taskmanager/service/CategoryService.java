package com.ivaylo.taskmanager.service;

import com.ivaylo.taskmanager.entity.Category;
import com.ivaylo.taskmanager.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;

  @Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
      public void deleteById(UUID id) {
          categoryRepository.deleteById(id);
      }
}
