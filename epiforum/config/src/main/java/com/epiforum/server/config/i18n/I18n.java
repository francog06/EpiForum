package com.epiforum.server.config.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18n {
	
	public enum MessageKey {
		ERROR_REQUEST_EXCEPTION_DEFAULT,
		ERROR_SERVER,
		ERROR_TECHNICAL_EXCEPTION_DEFAULT,
		ERROR_PARAMETER_EXCEPTION_DEFAULT,
		ERROR_NO_CONTACT_SEND,
		ERROR_CREDENTIAL_EXCEPTION_DEFAULT,
		ERROR_CREDENTIAL_EXCEPTION_EMPTY,
		ERROR_CREDENTIAL_EXCEPTION_LOCALE,
		ERROR_RESTSERVICE_PARAMETER_REQUIRED,
		ERROR_RESTSERVICE_PARAMETER_EMPTYFIELD,
		ERROR_RESTSERVICE_PARAMETER_BADSTARTINDEX,
		ERROR_RESTSERVICE_PARAMETER_BADTERMS,
		ERROR_RESTSERVICE_PARAMETER_BADLOCALE,
		ERROR_RESTSERVICE_PARAMETER_BADDEVICETYPE,
		ERROR_RESTSERVICE_PARAMETER_BADIDENTIFIER,
		ERROR_RESTSERVICE_PARAMETER_BADUSERNAME,
		ERROR_RESTSERVICE_PARAMETER_BADPASSWORD,
		ERROR_RESTSERVICE_PARAMETER_BADEMAIL,
		ERROR_RESTSERVICE_PARAMETER_BADFORGOTPASSWORD,
		ERROR_RESTSERVICE_PARAMETER_BADNEWPASSWORD,
		ERROR_RESTSERVICE_PARAMETER_PHONEALREADYEXIST,
		ERROR_RESTSERVICE_PARAMETER_EMAILALREADYEXIST,
		ERROR_RESTSERVICE_PARAMETER_BADPROFILENAME,
		ERROR_RESTSERVICE_PARAMETER_BADEXTENSION,
		ERROR_RESTSERVICE_PARAMETER_BADFILENAME,
		ERROR_RESTSERVICE_PARAMETER_NOFILE,
		EMAIL_SIGNATURE,
		EMAIL_ACTIVATION_CONFIRMATION_CONTENT_SUBJECT,
		EMAIL_ACTIVATION_CONFIRMATION_CONTENT_TITLE,
		EMAIL_ACTIVATION_CONFIRMATION_CONTENT_MESSAGE,
		EMAIL_ACTIVATION_CONFIRMATION_CONTENT_VALIDATE,
		EMAIL_ACTIVATION_VALIDATION_TITLE,
		EMAIL_ACTIVATION_VALIDATION_MESSAGE,
		EMAIL_ACTIVATION_VALIDATION_NOTFOUND,
		EMAIL_ACTIVATION_VALIDATION_ACTIVATED,
		EMAIL_ACTIVATION_VALIDATION_DELETED,
		EMAIL_ACTIVATION_VALIDATION_DISABLED,
		EMAIL_ACTIVATION_VALIDATION_PENDING,
		EMAIL_FORGOT_PASSWORD_CONTENT_SUBJECT,
		EMAIL_FORGOT_PASSWORD_CONTENT_TITLE,
		EMAIL_FORGOT_PASSWORD_CONTENT_MESSAGE,
		FRIENDSHIP_CREATE_MESSAGE,
		NOTIFICATION_ACCOUNT_ACTIVATION,
		TEXT_YOU,
		NONE
	}
	
	public static String getMessage(MessageKey messageKey, String locale) {

		try {
			ResourceBundle bundle = null;
			Locale localeObject = getLocaleObject(locale);
			String strMessagekey = messageKey.toString().toLowerCase().replace('_', '.');
			if (localeObject == null) {
				bundle = ResourceBundle.getBundle("com.cubbyhole.server.config.i18n.Message", new XMLResourceBundleControl());
			} else {
				bundle = ResourceBundle.getBundle("com.cubbyhole.server.config.i18n.Message", localeObject, new XMLResourceBundleControl());
			}
			String message = bundle.getString(strMessagekey);
			return message;
		} catch (Exception e) {
			System.out.println(String.format("I18n.getMessage : messageKey '%s' not found.", messageKey.toString().toLowerCase()));
			return "-";
		}
	}

	public static String getMessage(MessageKey messageKey, String locale, MessageKey defaultMessageKey) {
		if (messageKey == MessageKey.NONE)
			return getMessage(defaultMessageKey, locale);
		return getMessage(messageKey, locale);
	}

	private static Locale getLocaleObject(String locale) {

		if (locale == null)
			return null;

		Locale localeObj = null;
		String[] split = locale.split("_");
		if (split.length == 1)
			localeObj = new Locale(split[0]);
		else if (split.length == 2)
			localeObj = new Locale(split[0], split[1]);
		else if (split.length == 3)
			localeObj = new Locale(split[0], split[1], split[2]);

		return localeObj;
	}
}
