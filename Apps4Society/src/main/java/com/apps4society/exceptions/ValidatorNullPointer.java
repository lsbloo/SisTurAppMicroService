package com.apps4society.exceptions;

public class ValidatorNullPointer extends NullPointerException{
	
	private String msg;
	
	
	public ValidatorNullPointer(String msg) {
		super("Nenhum dado foi retornado de:" +msg);
		this.msg=msg;
		
	}
	
	
	public String getMsg() {
		return msg;
	}

}
