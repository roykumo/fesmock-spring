package com.btpn.fesmock.rest;

import com.btpn.fesmock.model.Transfer;
import com.btpn.fesmock.service.AngularService;
import com.btpn.fesmock.service.impl.AngularServiceImpl;

public class TestController {

	public static void main(String[] args) {
		AngularService angularService = new AngularServiceImpl();
		angularService.addCountry(new Transfer());
	}
}
