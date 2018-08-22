package com.apps4society.utilidades;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
public class MyCalendar {

	public static Calendar myCalendar;
	public static Date data_cadastro;
	
	
	public MyCalendar() {
		/*
		 * Cria uma instancia da classe calendar e me recupera alguns metodos interessantes;
		 * 
		 * !
		 * 
		 */
		
	}
	
	public String returnData() {
		data_cadastro = new Date();
		String DCD = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(data_cadastro);
		
		return DCD;
		
		
	}
}
