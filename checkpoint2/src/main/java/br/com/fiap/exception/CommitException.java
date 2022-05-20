package br.com.fiap.exception;

public class CommitException extends Exception {
	
	public CommitException() {
		super("An error to do commit...");
	}
	
	public CommitException(String msg) {
		super(msg);
	}

}
