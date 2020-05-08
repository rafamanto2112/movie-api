package br.com.vital.moviesapi.exceptions;

public class BusinessException extends RuntimeException {

	public BusinessException(final String message) {
		super(message);
	}

	private static final long serialVersionUID = 1L;

}
