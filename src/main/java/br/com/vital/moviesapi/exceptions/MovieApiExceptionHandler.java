package br.com.vital.moviesapi.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@EnableWebMvc
@ControllerAdvice
public class MovieApiExceptionHandler extends ResponseEntityExceptionHandler {

	private final Integer BUSINESS_STATUS_CODE = 530;

	@ExceptionHandler(BusinessException.class)
	protected ResponseEntity<String> handleBusinessException(final RuntimeException ex, final WebRequest request) {
		return new ResponseEntity<>("Erro no serviço de negócio; " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(TechinicalException.class)
	protected ResponseEntity<String> handleTechinicalException(final RuntimeException ex, final WebRequest request) {
		return ResponseEntity.status(BUSINESS_STATUS_CODE).body("Falha de negócio");
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handleAnyException(final Throwable ex, final HttpServletRequest request) {
		return new ResponseEntity<>("URL não encontrada ", HttpStatus.INTERNAL_SERVER_ERROR);
	}




}
