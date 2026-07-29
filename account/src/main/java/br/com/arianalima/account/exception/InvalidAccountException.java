package br.com.arianalima.account.exception;

public class InvalidAccountException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InvalidAccountException(String msg) {
		super(msg);
	}
}