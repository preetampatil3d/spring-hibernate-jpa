package com.project.springhibernatejpa.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.springhibernatejpa.model.User;
import com.project.springhibernatejpa.repository.UserRepository;

@RestController
@RequestMapping("/")
public class UsersResource {
	
	@RequestMapping("")
	public String hello() {
		return "Hello";
	}
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("all")
	public @ResponseBody Iterable<User> getAll(){
		return userRepository.findAll();
	}
	
	
	@GetMapping("add")
	public @ResponseBody String addNewUser(@RequestParam String name,@RequestParam String email) {
		
		User user = new User(name,email);
		userRepository.save(user);
		return "saved";
	}

}
