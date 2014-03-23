package com.epiforum.server.logic.utils;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

public class PhoneValidator {

	public static boolean isPhoneNumber(String phone, String countryCode) throws NumberParseException {
		PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
		PhoneNumber tel = phoneUtil.parse(phone, countryCode);
		return phoneUtil.isValidNumber(tel);
	}
}