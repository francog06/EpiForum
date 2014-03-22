package com.epiforum.server.logic.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class BadParametersException extends CubbyholeException {

	private static final long	serialVersionUID = 1L;

	public BadParametersException(String msg) {
		super(msg);
	}
}
