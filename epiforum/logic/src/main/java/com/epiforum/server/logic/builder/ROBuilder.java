package com.epiforum.server.logic.builder;

import com.epiforum.common.ro.MyProfileRO;
import com.epiforum.common.ro.RandomPasswordRO;
import com.epiforum.server.data.entity.Profile;
import com.epiforum.server.data.entity.Session;

public class ROBuilder {

	private ROBuilder() {}

	public static RandomPasswordRO	createRO(String pass) {
		RandomPasswordRO passwordRo = new RandomPasswordRO();
		passwordRo.setPassword(pass);
		return passwordRo;
	}

	public static MyProfileRO createRO(Profile pro, Session se) {
		// TODO Auto-generated method stub
		return null;
	}
}
