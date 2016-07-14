package com.cooksys.number_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.number_project.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}