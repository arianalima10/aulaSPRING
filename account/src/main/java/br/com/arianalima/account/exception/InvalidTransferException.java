package br.com.arianalima.account.exception;

public class InvalidTransferException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InvalidTransferException(String msg) {
		super(msg);
	}
}