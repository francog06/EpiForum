package com.epiforum.server.logic.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class BadRequestException extends CubbyholeException {

	private static final long	serialVersionUID = 1L;

	public BadRequestException(String msg) {
		super(msg);
	}	
}
