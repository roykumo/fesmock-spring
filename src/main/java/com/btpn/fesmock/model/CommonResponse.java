package com.btpn.fesmock.model;

public class CommonResponse {
	private String responseCode;
	private String responseDescription;
	
	public CommonResponse(){
		
	}
	
	public CommonResponse(String responseCode, String responseDescription){
		this.responseCode=responseCode;
		this.responseDescription=responseDescription;
	}
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseDescription() {
		return responseDescription;
	}
	public void setResponseDescription(String responseDescription) {
		this.responseDescription = responseDescription;
	}
	
	@Override
	public String toString(){
		return this.responseCode+" - "+this.responseDescription;
	}
}
