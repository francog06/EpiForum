package com.epiforum.server.logic.application;

import com.epiforum.server.config.properties.Configuration;

 public class Application {
	 
	 private Application() {}
	 
	private static String	name = "EpiForum";
	private static String	color = "black";
	private static String	background = "white";
	
	private static String	countryCode = Configuration.getDefaultCountryCode();
	private static String	locale = Configuration.getDefaultLocale();

	private static String	activationUrl = Configuration.getActivationUrl();
	private static String	webServerUrl = Configuration.getWebServerUrl();

	private static String	systemPathFile = Configuration.getFileSystemPathFile();

	private static String	emailNoReplyAddress = Configuration.getMailNoReplyAddress();
	private static String	emailActivationAddress = Configuration.getMailActivationAddress();
	private static String	emailContactAddress = Configuration.getMailContactAddress();

	/**
	 * @return the name
	 */
	 public static String getName() {
		return name;
	}
	/**
	 * @return the color
	 */
	public static String getColor() {
		return color;
	}
	/**
	 * @return the background
	 */
	public static String getBackground() {
		return background;
	}
	/**
	 * @return the countryCode
	 */
	 public static String getCountryCode() {
		return countryCode;
	}
	/**
	 * @return the locale
	 */
	 public static String getLocale() {
		return locale;
	}
	/**
	 * @return the activationUrl
	 */
	 public static String getActivationUrl() {
		return activationUrl;
	}
	/**
	 * @return the webServerUrl
	 */
	 public static String getWebServerUrl() {
		return webServerUrl;
	}
	/**
	 * @return the systemPathFile
	 */
	 public static String getSystemPathFile() {
		return systemPathFile;
	}
	/**
	 * @return the emailNoreplyAddress
	 */
	 public static String getEmailNoReplyAddress() {
		return emailNoReplyAddress;
	}
	/**
	 * @return the emailActivationAddress
	 */
	 public static String getEmailActivationAddress() {
		return emailActivationAddress;
	}
	/**
	 * @return the emailContactAddress
	 */
	public static String getEmailContactAddress() {
		return emailContactAddress;
	}
}