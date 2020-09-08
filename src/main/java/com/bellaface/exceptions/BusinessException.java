package com.bellaface.exceptions;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -8033912421970422943L;

	public BusinessException(Object obj) {
		super(obj.toString());
	}
}