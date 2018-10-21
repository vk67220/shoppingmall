package com.shoppingmall.exception;

/**
 * @author muralinutalapati
 */
public class CustomerNotFoundException extends RuntimeException {
	public CustomerNotFoundException(String s) {
		super(s);
	}
}
