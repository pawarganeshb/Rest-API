package com.app.exceptions;

import com.app.handler.ExceptionController;

public class ProductNotFoundException extends RuntimeException {

	/**
	 * This exception occur when use trying to access not exits product
	 */
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(ExceptionController ex) {
		super();
		ex.handleException("Product Not Found");

	}

}
