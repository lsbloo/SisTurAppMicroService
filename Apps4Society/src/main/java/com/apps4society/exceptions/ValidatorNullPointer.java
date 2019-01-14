package com.apps4society.exceptions;

public class ValidatorNullPointer extends NullPointerException{
	
	private String msg;
	
	
	public ValidatorNullPointer(String msg) {
		super(msg);
		this.msg=msg;
		
	}
	
	public String getMsg() {
		return msg;
	}

}
