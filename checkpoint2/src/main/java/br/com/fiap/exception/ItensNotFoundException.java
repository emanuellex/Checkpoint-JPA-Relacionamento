package br.com.fiap.exception;

public class ItensNotFoundException extends Exception {
	
	public ItensNotFoundException() {
		super("n�o encontrado");
	}
	
	public ItensNotFoundException(String msg) {
		super(msg);		
	}

}
