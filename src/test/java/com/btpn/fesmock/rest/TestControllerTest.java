package com.btpn.fesmock.rest;

import javax.annotation.Generated;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;
import org.mockserver.junit.MockServerRule;

import com.btpn.fesmock.rest.util.RestHelper;

@Generated(value = "org.junit-tools-1.0.4")
public class TestControllerTest {

	@Rule
	public MockServerRule mockServerRule = new MockServerRule(RestHelper.class, 8780);
	
	@Before
	public void setUp() throws Exception {

	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	private TestController createTestSubject() {
		return new TestController();
	}

	@MethodRef(name = "main", signature = "([QString;)V")
	@Test
	public void testMain() throws Exception {
		String[] args = new String[] { "" };

		// default test
		TestController.main(args);
	}
}