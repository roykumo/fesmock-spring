package com.btpn.fesmock.service;

import java.util.List;

import com.btpn.fesmock.model.User;

public interface UserService {
	void addUser(User user);
	User getUser(String id);
	List<User> getListUser();
}
