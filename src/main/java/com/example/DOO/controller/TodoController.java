package com.example.DOO.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		return todoService.getAllTodos();
	}
}