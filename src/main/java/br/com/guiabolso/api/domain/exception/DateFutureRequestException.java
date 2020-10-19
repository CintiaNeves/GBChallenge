package br.com.guiabolso.api.domain.exception;

public class DateFutureRequestException  extends APIException{

	private static final long serialVersionUID = 1L;

	public DateFutureRequestException(String message) {
		super(message);
		
	}

}
