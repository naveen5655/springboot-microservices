package com.klu.springboot.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.klu.springboot.user.entity.Contact;
import com.klu.springboot.user.entity.User;
import com.klu.springboot.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/{userId}")
	public User getUser(@PathVariable("userId") Long id) {
		User user = userService.getUser(id);
		List<Contact> clist = this.restTemplate.getForObject("http://contact-service/contact/user/" + user.getUserId(), List.class);
		user.setContacts(clist);
		return user;
	}
	@GetMapping("/error")
	public String error()
	{
		return "404-not fount";
	}
}
