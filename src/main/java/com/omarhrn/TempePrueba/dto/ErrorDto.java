package com.omarhrn.TempePrueba.dto;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import lombok.Data;
/**
 * Objeto error custom
 * @author omarhrn
 *
 */

@Data
public class ErrorDto implements Serializable {
	
	private static final long serialVersionUID = -2789678763063639474L;

	private HttpStatus status;
	private String message;
}
