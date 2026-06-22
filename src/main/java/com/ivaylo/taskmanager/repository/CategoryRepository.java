package com.ivaylo.taskmanager.repository;

import com.ivaylo.taskmanager.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
