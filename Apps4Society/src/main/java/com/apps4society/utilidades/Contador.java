package com.apps4society.utilidades;

public class Contador extends Thread{
	
	private long init;
	private long finalx;
	private long total=0;
	
	
	
	public Contador(int valorInicial,int valorFinal) {
		this.init=valorInicial;
		this.finalx=valorFinal;
	}
	
	
	public long getTotal() {
		return total;
	}

	@Override
	public void run() {
		for(long i = init;i<=finalx;i++) {
			total+=1;
		}
	}
}
