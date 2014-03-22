package com.epiforum.server.logic.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class BadCredentialException extends CubbyholeException {

	private static final long	serialVersionUID = 1L;

	public BadCredentialException(String msg) {
		super(msg);
	}
}
