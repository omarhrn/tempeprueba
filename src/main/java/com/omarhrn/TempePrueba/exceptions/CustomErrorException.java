package com.omarhrn.TempePrueba.exceptions;

/**
 * Excepción personalizada
 * @author omarhrn
 *
 */
public class CustomErrorException extends Exception{

	private static final long serialVersionUID = -1894879039792488322L;
	
	public CustomErrorException(String errorMessage) {
		super(errorMessage);
	}
}
