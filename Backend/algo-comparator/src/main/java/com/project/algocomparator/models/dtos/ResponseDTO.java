package com.project.algocomparator.models.dtos;

import org.springframework.http.HttpStatus;

public class ResponseDTO {
	
	private HttpStatus responseCode;
	private String responseMessage;
	
	public ResponseDTO(HttpStatus responseCode, String responseMessage) {
		super();
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}

	public HttpStatus getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(HttpStatus responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	@Override
	public String toString() {
		return "ResponseDTO [responseCode=" + responseCode + ", responseMessage=" + responseMessage + "]";
	}
}
