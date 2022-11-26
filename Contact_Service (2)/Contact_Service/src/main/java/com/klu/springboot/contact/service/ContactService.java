package com.klu.springboot.contact.service;

import java.util.List;

import com.klu.springboot.contact.entity.Contact;

public interface ContactService {
	public List<Contact> getContactsOfUser(Long userId);
}
