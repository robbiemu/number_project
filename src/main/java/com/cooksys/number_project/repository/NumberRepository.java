package com.cooksys.number_project.repository;

import com.cooksys.number_project.model.Number;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NumberRepository extends JpaRepository<Number, Long> {
	Number findByNindex(Integer num);
}
