package br.com.flux.model;

@SuppressWarnings("serial")
public class ParametrosInvalidosException extends Exception{

	private String message;
	
	public ParametrosInvalidosException() {
		super();
		this.message = "O segundo n�mero deve ser maior que o primeiro!";
	}
	
	public String getMessage() {
		return this.message;
	}
	
}
