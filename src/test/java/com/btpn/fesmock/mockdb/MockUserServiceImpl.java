package com.btpn.fesmock.mockdb;

import java.util.ArrayList;
import java.util.List;

import com.btpn.fesmock.model.User;
import com.btpn.fesmock.service.UserService;

public class MockUserServiceImpl implements UserService{
	public void addUser(User user){
		System.out.println("done add user mock : "+user.toString());
	}
	
	public User getUser(String id){
		System.out.println("mock getUser : "+id);
		User user = null;
		
		if(id!=null && !id.equalsIgnoreCase("")){
			user = new User();
			user.setId(id);
			user.setName("User Mock "+id);
			user.setPosition("Position Mock "+id);
		}
		
		//System.out.println("returned user mock "+(user==null?"":user.toString()));
		
		return user;
	}
	
	public List<User> getListUser(){
		List<User> list = new ArrayList<User>();
		for (int i = 0; i < 3; i++) {
			User user = new User();
			user.setId(String.valueOf(i+1));
			user.setName("User Mock "+i);
			user.setPosition("Position Mock "+i);
			list.add(user);
		}
		
		return list;
	}
}
