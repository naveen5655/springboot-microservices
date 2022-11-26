package com.klu.springboot.contact.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.klu.springboot.contact.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	//fake contact list
	List<Contact> contacts = List.of(
			new Contact(1L,"rajesh@gmail.com","Rajesh",1311L),
			new Contact(2L,"rajani@gmail.com","Rajanikanth",1311L),
			new Contact(3L,"kishore@gmail.com","Kishore",1313L),
			new Contact(4L,"ramaiah@gmail.com","Ramaiah",1314L),
			new Contact(5L,"kishore@gmail.com","Kishore",1314L),
			new Contact(6L,"kiran@gmail.com","Kiran",1312L)
			);
	
	@Override
	public List<Contact> getContactsOfUser(Long userId) {
		return contacts.stream().filter(contact -> contact.getUserId().equals(userId)).collect(Collectors.toList());
	}

}
