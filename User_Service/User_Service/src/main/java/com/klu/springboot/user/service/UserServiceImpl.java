package com.klu.springboot.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.klu.springboot.user.entity.User;

@Service
public class UserServiceImpl implements UserService {

	//fake user list
	List<User> list = List.of(
			new User(1311L,"Rajesh","234567"),
			new User(1312L,"Kiran","9999666"),
			new User(1313L,"Ramya","88888"),
			new User(1314L,"Kiranmai","12122334")
			);
	
	@Override
	public User getUser(Long id) {
		return list.stream().filter(user -> user.getUserId().equals(id)).findAny().orElse(null);
	}
}
