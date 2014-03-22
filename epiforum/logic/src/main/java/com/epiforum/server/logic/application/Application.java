package com.epiforum.server.logic.application;

import com.epiforum.server.config.properties.Configuration;

 public class Application {

	private final String	name = "EpiForum";
	private final String	color = "black";
	private final String	background = "white";
	
	private final String	countryCode = Configuration.getDefaultCountryCode();
	private final String	locale = Configuration.getDefaultLocale();

	private final String	activationUrl = Configuration.getActivationUrl();
	private final String	webServerUrl = Configuration.getWebServerUrl();

	private final String	systemPathFile = Configuration.getFileSystemPathFile();

	private final String	emailNoreplyAddress = Configuration.getMailNoReplyAddress();
	private final String	emailActivationAddress = Configuration.getMailActivationAddress();

	/**
	 * @return the name
	 */
	 public String getName() {
		return name;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @return the background
	 */
	public String getBackground() {
		return background;
	}
	/**
	 * @return the countryCode
	 */
	 public String getCountryCode() {
		return countryCode;
	}
	/**
	 * @return the locale
	 */
	 public String getLocale() {
		return locale;
	}
	/**
	 * @return the activationUrl
	 */
	 public String getActivationUrl() {
		return activationUrl;
	}
	/**
	 * @return the webServerUrl
	 */
	 public String getWebServerUrl() {
		return webServerUrl;
	}
	/**
	 * @return the systemPathFile
	 */
	 public String getSystemPathFile() {
		return systemPathFile;
	}
	/**
	 * @return the emailNoreplyAddress
	 */
	 public String getEmailNoreplyAddress() {
		return emailNoreplyAddress;
	}
	/**
	 * @return the emailActivationAddress
	 */
	 public String getEmailActivationAddress() {
		return emailActivationAddress;
	}
}