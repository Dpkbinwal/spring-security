package com.dpkbinwal.learn_spring_security.resources;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;

@RestController
public class TodoResource {
	
	private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

	private static final List<Todo> TODO_LIST = List.of(new 
			Todo("dpkbinwal","Learn aws"),
			new Todo("dpkbinwal","Learn webdev"));

	@GetMapping("/")
	public List<Todo> retrieveAllTodos() {
		return TODO_LIST;
	}
	
	@GetMapping(path = "/users/{username}/todo")
	public Todo retrieveTodosForSpecificUser(@PathVariable("username") String username){
		return TODO_LIST.get(0);
	}
	
	@PostMapping(path = "/users/{username}/todo")
	public void createTodosForSpecificUser(@PathVariable("username") String username,@RequestBody Todo todo ){
		logger.info("Create {} for {}", todo, username);
	}
	
}
record Todo (String username,String description) {}
