package com.btpn.fesmock.rest;

import java.util.List;

import javax.annotation.Generated;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.btpn.fesmock.mockdb.MockUserServiceImpl;
import com.btpn.fesmock.model.CommonResponse;
import com.btpn.fesmock.model.User;
import com.btpn.fesmock.service.UserService;

@Generated(value = "org.junit-tools-1.0.4")
public class UserControllerTest {
	
	@Mock
	private UserService service;
	
	@Rule
	public MockitoRule rule = MockitoJUnit.rule();

	@Before
	public void setUp() throws Exception {
		service = (UserService) new MockUserServiceImpl();
	}

	private UserController createTestSubject() {
		UserController controller = new UserController();
		controller.setService(service);
		return controller;
		//return new UserController();
	}

	@MethodRef(name = "getUser", signature = "(QString;)QUser;")
	@Test
	public void testGetUser() throws Exception {
		UserController testSubject;
		String id = "1";
		User result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getUser(id);
		
		System.out.println("testGetUser --- mock get user : "+result);
	}

	@MethodRef(name = "addUser", signature = "(QUser;)QCommonResponse;")
	@Test
	public void testAddUser() throws Exception {
		UserController testSubject;
		User user = service.getUser("1");
		CommonResponse result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.addUser(user);
		
		System.out.println("testAddUser --- mock add user : "+result);
	}

	@MethodRef(name = "getListUser", signature = "()QList<QUser;>;")
	@Test
	public void testGetListUser() throws Exception {
		UserController testSubject;
		List<User> result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getListUser();
		System.out.println("testGetListUser --- mock list : "+result.size());
	}
}