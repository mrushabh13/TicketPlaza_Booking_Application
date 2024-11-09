package com.api.ticketsplaza.exception;

public class ErrorResponse {

	private String errorCode;
    private String message;
	
    public ErrorResponse(String errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}
	
    public ErrorResponse() {
		super();
	}
	
    public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
    
    
}
