package com.btpn.fesmock.service.impl;

import com.btpn.fesmock.model.CommonResponse;
import com.btpn.fesmock.model.Transfer;
import com.btpn.fesmock.rest.util.RestHelper;
import com.btpn.fesmock.service.AngularService;

public class AngularServiceImpl implements AngularService {
	private static final String URL = "http://localhost:8780/5aSecServer/ng/transfer";

	public boolean addCountry(Transfer transfer) {
		try {
			/*CommonResponse response = (CommonResponse) RestHelper.getInstance()
					.httpRequestJSONGet(URL, transfer, CommonResponse.class);

			System.out.println("resCode : " + response.getResponseCode());
			System.out
					.println("resDesc : " + response.getResponseDescription());*/
			
			CommonResponse response = (CommonResponse) RestHelper.getInstance()
					.restTemplateJSONPost(URL, transfer, CommonResponse.class);

			System.out.println("resCode : " + response.getResponseCode());
			System.out
					.println("resDesc : " + response.getResponseDescription());

			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}

	}

}
