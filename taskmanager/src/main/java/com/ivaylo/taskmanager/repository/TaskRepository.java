package com.ivaylo.taskmanager.repository;

import com.ivaylo.taskmanager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}