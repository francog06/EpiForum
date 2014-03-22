package com.epiforum.server.logic.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class TechnicalException extends CubbyholeException {

	private static final long	serialVersionUID = 1L;

	public TechnicalException(String message) {
		super(message);
	}

	public TechnicalException(Exception e) {
		super(e);
	}
}
