package com.btpn.fesmock.persistence;

import java.util.List;

import com.btpn.fesmock.model.User;

public class PersistentManager {
	public void addUser(User user) {
		//System.out.println("done add user");
		throw new UnsupportedOperationException();
	}
	
	public User getUser(String id){
		/*User user = null;
		
		if(id!=null && !id.equalsIgnoreCase("")){
			user = new User();
			user.setId(id);
			user.setName("User "+id);
			user.setPosition("Position "+id);
		}
		
		System.out.println("returned user "+user==null?"":user.getId());
		
		return user;*/
		throw new UnsupportedOperationException();
	}
	
	public List<User> getListUser(){
		/*List<User> list = new ArrayList<User>();
		for (int i = 0; i < 3; i++) {
			User user = new User();
			user.setId(String.valueOf(i+1));
			user.setName("User "+i);
			user.setPosition("Position "+i);
			list.add(user);
		}
		
		return list;*/
		throw new UnsupportedOperationException();
	}
}
