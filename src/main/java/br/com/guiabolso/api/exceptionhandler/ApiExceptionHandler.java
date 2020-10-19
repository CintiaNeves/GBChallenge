package br.com.guiabolso.api.exceptionhandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.time.OffsetDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.guiabolso.api.domain.exception.DateFutureRequestException;
import br.com.guiabolso.api.domain.exception.OutOfRangeMonthException;
import br.com.guiabolso.api.domain.exception.OutOfRangeYearException;
import br.com.guiabolso.api.domain.exception.UserNotFoundException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
			
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handlerEntityNotFound(UserNotFoundException ex, WebRequest request) {
		
		HttpStatus status = NOT_FOUND;
		Exception exception = new Exception();
		exception.setStatus(status.value());
		exception.setTitulo(ex.getMessage());
		exception.setDataHora(OffsetDateTime.now());
		
		return handleExceptionInternal(ex, exception, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(OutOfRangeYearException.class)
	public ResponseEntity<Object> handlerEntityNotFound(OutOfRangeYearException ex, WebRequest request) {
		
		HttpStatus status = BAD_REQUEST;
		Exception exception = new Exception();
		exception.setStatus(status.value());
		exception.setTitulo(ex.getMessage());
		exception.setDataHora(OffsetDateTime.now());
		
		return handleExceptionInternal(ex, exception, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(OutOfRangeMonthException.class)
	public ResponseEntity<Object> handlerEntityNotFound(OutOfRangeMonthException ex, WebRequest request) {
		
		HttpStatus status = BAD_REQUEST;
		Exception exception = new Exception();
		exception.setStatus(status.value());
		exception.setTitulo(ex.getMessage());
		exception.setDataHora(OffsetDateTime.now());
		
		return handleExceptionInternal(ex, exception, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(DateFutureRequestException.class)
	public ResponseEntity<Object> handlerEntityNotFound(DateFutureRequestException ex, WebRequest request) {
		
		HttpStatus status = BAD_REQUEST;
		Exception exception = new Exception();
		exception.setStatus(status.value());
		exception.setTitulo(ex.getMessage());
		exception.setDataHora(OffsetDateTime.now());
		
		return handleExceptionInternal(ex, exception, new HttpHeaders(), status, request);
	}
}
