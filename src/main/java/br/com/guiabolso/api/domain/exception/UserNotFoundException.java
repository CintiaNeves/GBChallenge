package br.com.guiabolso.api.domain.exception;

public class UserNotFoundException extends APIException{

	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String message) {
		super(message);
		
	}

}
