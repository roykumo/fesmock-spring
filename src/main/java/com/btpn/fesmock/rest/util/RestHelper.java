package com.btpn.fesmock.rest.util;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestHelper {
	private static RestHelper INSTANCE = new RestHelper();
	
	public static RestHelper getInstance(){
		if(INSTANCE == null){
			INSTANCE = new RestHelper();
		}
		return INSTANCE;
	}
	
	/*@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> Object httpRequestJSONGet(String url, T object, Class returnClass){
		Client client = null;
		Object output = null;
		try {
			client = Client.create();

			WebResource webResource = client.resource(url);

			ClientResponse response = webResource.type("application/json")
					.post(ClientResponse.class, object);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			System.out.println("Output from Server .... \n");
			output = response.getEntity(returnClass);
		}catch(Exception e){
			System.out.println("error "+e.toString());
		}
		
		return output;
	}*/
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> Object restTemplateJSONPost(String url, T object, Class returnClass){
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> response
		  = restTemplate.postForEntity(url, object, returnClass);
				
		return response.getBody();
	}
}
