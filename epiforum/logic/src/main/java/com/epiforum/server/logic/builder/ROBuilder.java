package com.epiforum.server.logic.builder;

import com.epiforum.common.ro.RandomPasswordRO;

public class ROBuilder {

	private ROBuilder() {}

	public static RandomPasswordRO	createRO(String pass) {
		RandomPasswordRO passwordRo = new RandomPasswordRO();
		passwordRo.setPassword(pass);
		return passwordRo;
	}
}
