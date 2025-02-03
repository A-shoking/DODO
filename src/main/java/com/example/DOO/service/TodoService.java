package com.example.DOO.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DOO.model.Todo;
import com.example.DOO.repo.TodoRepository;
@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;
	
//	@Autowired
//	private CreateRepository createTodo;

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
	
	 public Todo createTodo(String heading, String progress, String date , Long id) {
		 	Random random = new Random();
		 	 Long randomNumber = (long) random.nextInt(1000);
	        Todo todo = new Todo();
	        todo.setTitle(heading);
	        todo.setStatus(progress);
	        todo.setDate(date);
	        if(id != null) {
	        	todo.setId(id);
	        }else { todo.setId(randomNumber);}
	       
	        return todoRepository.save(todo);
	    }
}
