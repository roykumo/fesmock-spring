package com.btpn.fesmock.service.impl;

import java.util.List;

import com.btpn.fesmock.model.User;
import com.btpn.fesmock.persistence.PersistentManager;
import com.btpn.fesmock.service.UserService;

public class UserServiceImpl implements UserService {
	PersistentManager persistentManager = new PersistentManager();

	public void addUser(User user) {
		persistentManager.addUser(user);
	}

	public User getUser(String id) {
		return persistentManager.getUser(id);
	}

	public List<User> getListUser() {
		return persistentManager.getListUser();
	}

}
