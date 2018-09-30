package com.apps4society.exceptions;

public class IndiceForaAlcance extends IndexOutOfBoundsException{
	
	/*
	 * Se nenhum atrativo for retornado
	 */
	private String msg;
	
	
	public IndiceForaAlcance(String msg) {
		super(msg);
		this.msg=msg;
	}
	

	
	public String getMessagem() {
		return this.msg;
	}
	
	public IndiceForaAlcance() {
		super("Nenhum Atrativo foi retornado com o nome do municipio especificado!");
	}
}
