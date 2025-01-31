package com.example.DOO.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DOO.model.Todo;
import com.example.DOO.repo.CreateRepository;
import com.example.DOO.repo.TodoRepository;
import java.util.Optional;
@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;
	
	@Autowired
	private CreateRepository createTodo;

	public List<Todo> getAllTodos() {
		return todoRepository.findAll();
	}

	public Optional<Todo> getById(Long id) {
		return todoRepository.findById(id);
		 // return Optional.ofNullable(todoRepository.getById(id));
	}
	public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }
	
	 public Todo createTodo(String heading, String progress, String date) {
	        Todo todo = new Todo();
	        todo.setTitle(heading);
	        todo.setStatus(progress);
	        todo.setDate(date);
	        return todoRepository.save(todo);
	    }
}
