package com.epiforum.server.logic.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

	private Pattern					pattern;
	
	private	Matcher					matcher;
	
	private static final String		emailExp =	"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + 
												"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public EmailValidator() {
		pattern = Pattern.compile(emailExp);
	}
	
	public boolean validate(final String email) {
		matcher = pattern.matcher(email);
		return matcher.matches();
	}
}