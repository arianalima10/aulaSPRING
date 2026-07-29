package br.com.arianalima.account.exception;

public class InvalidBalanceAccountException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InvalidBalanceAccountException(String msg) {
		super(msg);
	}
}