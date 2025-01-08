package com.app.exceptions;

public class ProductNotFoundException extends RuntimeException {

	/**
	 * This exception occur when use trying to access not exits product
	 */
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(String string) {
		super();

	}

}
