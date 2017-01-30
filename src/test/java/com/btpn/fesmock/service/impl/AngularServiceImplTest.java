package com.btpn.fesmock.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;

import javax.annotation.Generated;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.tools.configuration.base.MethodRef;
import org.mockserver.client.server.MockServerClient;
import org.mockserver.junit.MockServerRule;
import org.mockserver.model.*;
import org.mockserver.verify.VerificationTimes;

import com.btpn.fesmock.model.Transfer;
import com.btpn.fesmock.rest.util.RestHelper;

@Generated(value = "org.junit-tools-1.0.4")
public class AngularServiceImplTest {
	@Rule
	public MockServerRule mockServerRule = new MockServerRule(RestHelper.class, 8780);
 
	private MockServerClient mockServerClient;
	
	@Generated(value = "org.junit-tools-1.0.4")
	private Logger logger = Logger.getLogger(AngularServiceImplTest.class
			.toString());

	@Before
	public void setUp() throws Exception {
		//http://localhost:8780/5aSecServer/ng/transfer
		mockServerClient = new MockServerClient("localhost", 8780);
		 
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}
	
	@MethodRef(name = "addCountry", signature = "(QTransfer;)V")
	@Test
	public void testAddCountry() throws Exception {
		mockServerClient.when(
								HttpRequest.request()
								.withPath("/5aSecServer/ng/transfer")
								.withMethod("POST")
							).respond(
								HttpResponse.response()
								.withHeaders(
	                                new Header("Content-Type", "application/json; charset=utf-8")
		                        )
								.withBody("{\"responseCode\":\"0\",\"responseDescription\":\"transfer done\"}")
								.withStatusCode(200)
							);
		
		//angularServiceMock = createTestSubject();
		
		//when(angularServiceMock.addCountry(null)).thenReturn(true);
		
		//verify(angularServiceMock).addCountry(null);
		//verify(angularServiceMock).addCountry(transferMock);
		
		//when(angularServiceMock.addCountry(transferMock)).thenReturn(false);
		//assertEquals(true, angularServiceMock.addCountry(new Transfer()));
		
		assertEquals(true, new AngularServiceImpl().addCountry(new Transfer()));
		//System.out.println(new AngularServiceImpl().addCountry(new Transfer()));
		
		mockServerClient.verify(HttpRequest.request("/5aSecServer/ng/transfer"), VerificationTimes.once());
				
		/*// default test
		testSubject = createTestSubject();
		testSubject.addCountry(transfer);

		Assert.fail();*/
		//assertEquals(angularServiceMock.addCountry(null), false);
	}
}