package com.klu.springboot.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.springboot.contact.entity.Contact;
import com.klu.springboot.contact.service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@GetMapping("/user/{userId}")
	public List<Contact> getContacts(@PathVariable("userId") Long id){
			return contactService.getContactsOfUser(id);
	}
	@GetMapping("/error")
	public String error()
	{
		return "404-not fount";
	}
}
