package br.com.vital.moviesapi.exceptions;

public class TechinicalException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TechinicalException(final String message, final Throwable e) {
		super(message, e);
	}

}
