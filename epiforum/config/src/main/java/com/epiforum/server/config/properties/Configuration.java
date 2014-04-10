package com.epiforum.server.config.properties;

import java.io.IOException;
import java.util.Properties;

public class Configuration {

	private static Properties	generalConfigFile	= null;

	static {

		String mode = System.getProperty("mode");
		if (!"dev".equals(mode) && !"local".equals(mode)) {
			mode = "prod";
		}

		generalConfigFile = new Properties();

		try {
			generalConfigFile.load(Configuration.class.getResourceAsStream("/com/epiforum/server/config/properties/general-config.properties"));
			generalConfigFile.load(Configuration.class.getResourceAsStream("/com/epiforum/server/config/properties/general-config-" + mode + ".properties"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String getProperty(String property) {
		if (property == null || generalConfigFile == null) {
			return null;
		}
		return generalConfigFile.getProperty(property);
	}
	
	public static String getDefaultCountryCode() {
		return getProperty("default.countryCode");
	}
	
	public static String getDefaultLocale() {
		return getProperty("default.locale");
	}
	
	public static String getApplicationName() {
		return getProperty("application.name");
	}
	
	public static String getApplicationColor() {
		return getProperty("application.color");
	}
	
	public static String getApplicationBackground() {
		return getProperty("application.background");
	}
	
	public static String getMailAdminAddress() {
		return getProperty("mail.admin.address");
	}

	public static String getMailActivationAddress() {
		return getProperty("mail.activation.address");
	}

	public static String getMailNoReplyAddress() {
		return getProperty("mail.noreply.address");
	}

	public static String getMailContactAddress() {
		return getProperty("mail.contact.address");
	}
	
	public static String getSmtpHost() {
		return getProperty("mail.smtp.host");
	}
	
	public static String getSmtpAuth() {
		return getProperty("mail.smtp.auth");
	}
	
	public static String getSmtpPort() {
		return getProperty("mail.smtp.port");
	}
	
	public static String getSmtpUser() {
		return getProperty("mail.smtp.user");
	}
	
	public static String getSmtpPassword() {
		return getProperty("mail.smtp.password");
	}
	
	public static String getSmtpProtocol() {
		return getProperty("mail.smtp.protocol");
	}

	public static String getFileUrl(String folder, String name) {
		return String.format(getProperty("server.file.url"), folder, name);
	}

	public static String getFileSystemPathFile() {
		return getProperty("server.path.file");
	}

	public static String getActivationUrl() {
		return getProperty("server.activation.url");
	}
	
	public static String getWebServerUrl() {
		return getProperty("web.server.url");
	}
}
