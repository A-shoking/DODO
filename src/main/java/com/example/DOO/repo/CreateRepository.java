package com.example.DOO.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DOO.model.Todo;
import com.example.DOO.model.TodoRequest;

@Repository
public interface CreateRepository extends JpaRepository<TodoRequest, Long> {

}
