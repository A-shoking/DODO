package com.example.DOO.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DOO.model.Todo;

import com.example.DOO.service.TodoService;

@RestController
public class TodoController {

	@Autowired
	private TodoService todoService;

	@GetMapping("/todos")
	public List<Todo> getAllTodos() {
		int x = 5; 
		return todoService.getAllTodos();
	}
	
	
//	@GetMapping("/todosUse/{id}")
//	public Optional<Todo> getIDTodos(@PathParam(value = "") Long id){
//	
//		return todoService.getById(id);
//	}
	
	@GetMapping("todosUse/{id}")
	public Optional<Todo> getIDTodos(@PathVariable Long id) {
	    return todoService.getById(id);
	}
	
//	  @GetMapping("todosUs/{id}")
//	    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
//	        Optional<Todo> todo = todoService.getTodoById(id);
//	        return todo.map(ResponseEntity::ok)
//	                   .orElseGet(() -> ResponseEntity.notFound().build());
//	    }

	
	  @PostMapping("create")
	    public ResponseEntity<Todo> createTodo(@RequestBody Map<String, String> requestBody) {
		  Long id = null;
	        if (requestBody.containsKey("Id") && requestBody.get("Id") != null) {
	            try {
	                id = Long.parseLong(requestBody.get("Id")); // Convert the string to Long
	            } catch (NumberFormatException e) {
	                // Return bad request if the Id cannot be parsed to a long
	                return ResponseEntity.badRequest().build();
	            }
	        }

	        Todo createdTodo = todoService.createTodo(
	               
	                requestBody.get("heading"),
	                requestBody.get("progress"),
	                requestBody.get("date"),
	                id
	        );
	        return ResponseEntity.status(201).body(createdTodo);
	    }
}