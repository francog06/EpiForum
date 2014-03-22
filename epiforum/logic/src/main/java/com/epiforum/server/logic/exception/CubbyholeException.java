package com.epiforum.server.logic.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public abstract class CubbyholeException extends Exception {

	private static final long	serialVersionUID = 1L;
	
	public CubbyholeException(String msg) {
		super(msg);
	}

	public CubbyholeException(Exception e) {
		super(e);
	}

}
