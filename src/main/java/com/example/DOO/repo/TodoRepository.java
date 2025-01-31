package com.example.DOO.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DOO.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
	// Custom query methods can be added here if needed
	// Optional<Todo> findById(Long id);
}


