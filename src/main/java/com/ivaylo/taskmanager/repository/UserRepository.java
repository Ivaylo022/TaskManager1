package com.ivaylo.taskmanager.repository;

import com.ivaylo.taskmanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}