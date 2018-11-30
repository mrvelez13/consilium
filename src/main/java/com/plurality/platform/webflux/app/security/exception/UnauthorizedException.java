package com.plurality.platform.webflux.app.security.exception;

/**
 * @author duc-d
 */
public class UnauthorizedException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnauthorizedException(String message) {
        super(message);
    }
}
