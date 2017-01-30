package com.btpn.fesmock.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.btpn.fesmock.model.CommonResponse;
import com.btpn.fesmock.model.User;
import com.btpn.fesmock.service.UserService;

public class UserController {
	@Autowired
	UserService service;
	
	public void setService(UserService service) {
		this.service = service;
	}

	public CommonResponse addUser(User user){
		try{
			service.addUser(user);
			return new CommonResponse("00", "sukses add user: "+user.toString());
		}catch(Exception e){
			return new CommonResponse("06", e.toString());
		}
	}
	
	public User getUser(String id){
		User user = service.getUser(id);
		return user;
	}
	
	public List<User> getListUser(){
		List<User> listUser = service.getListUser(); 
		return listUser;
	}
}
