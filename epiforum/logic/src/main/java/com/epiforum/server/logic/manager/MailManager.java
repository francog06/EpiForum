package com.epiforum.server.logic.manager;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.ejb.Stateless;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.IOUtils;

import com.epiforum.server.config.i18n.I18n;
import com.epiforum.server.config.i18n.I18n.MessageKey;
import com.epiforum.server.config.properties.Configuration;
import com.epiforum.server.data.bean.MailProperties;
import com.epiforum.server.logic.application.Application;
import com.epiforum.server.logic.exception.TechnicalException;

@Stateless
public class MailManager {

	private static final String MAIL_CONTENT_TYPE = "text/html; charset=utf-8";
	
	private String getNoReplyEmail(Application application) {
		String applicationName = Normalizer.normalize(application.getName(), Normalizer.Form.NFD) .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		return String.format("%s<%s>", applicationName, application.getEmailNoreplyAddress());
	}

	public void sendMail(MailProperties mailProperties) throws AddressException, MessagingException {
		Properties props = new Properties();

		props.put("mail.smtp.host", Configuration.getSmtpHost());
		props.put("mail.smtp.auth", Configuration.getSmtpAuth());

		Session session = Session.getDefaultInstance(props, null);
		Message message = new MimeMessage(session);

		message.setFrom(new InternetAddress(mailProperties.getFrom().trim()));

		// TO
		List<Address> addressToList = new ArrayList<Address>();
		Address[] addressesTo = null;
		if (mailProperties.getTo() != null) {

			addressesTo = new Address[mailProperties.getTo().size()];
			for (String strAddress : mailProperties.getTo()) {
				Address address = new InternetAddress(strAddress.trim());
				addressToList.add(address);
			}

			addressesTo = addressToList.toArray(addressesTo);
		}
		message.setRecipients(Message.RecipientType.TO, addressesTo);

		// CC
		List<Address> addressCcList = new ArrayList<Address>();
		Address[] addressesCc = null;
		if (mailProperties.getCc() != null) {

			addressesCc = new Address[mailProperties.getCc().size()];
			for (String strAddress : mailProperties.getCc()) {
				Address address = new InternetAddress(strAddress.trim());
				addressCcList.add(address);
			}

			addressesCc = addressCcList.toArray(addressesCc);
		}
		message.setRecipients(Message.RecipientType.CC, addressesCc);

		// BCC
		List<Address> addressBccList = new ArrayList<Address>();
		Address[] addressesBcc = null;
		if (mailProperties.getBcc() != null) {

			addressesBcc = new Address[mailProperties.getBcc().size()];
			for (String strAddress : mailProperties.getBcc()) {
				Address address = new InternetAddress(strAddress.trim());
				addressBccList.add(address);
			}

			addressesBcc = addressBccList.toArray(addressesBcc);
		}
		message.setRecipients(Message.RecipientType.BCC, addressesBcc);

		// SUBJECT
		message.setSubject(mailProperties.getSubject());

		// CONTENT
		message.setContent(mailProperties.getContent(), MAIL_CONTENT_TYPE);

		if (Configuration.getSmtpAuth().equals("true")) {
			;
			Transport tr = session.getTransport(Configuration.getSmtpProtocol());
			tr.connect(Configuration.getSmtpHost(), Integer.valueOf(Configuration.getSmtpPort()), Configuration.getSmtpUser(), Configuration.getSmtpPassword());
			message.saveChanges();
			tr.sendMessage(message, message.getAllRecipients());
			tr.close();
		} else {
			Transport.send(message);
		}
	}
	
	private String getMainTemplate(Application application, String subject) throws IOException {
		InputStream mainInputStream = getClass().getResourceAsStream("/com/epiforum/server/logic/mail/template/main.html");
		StringWriter mainWriter = new StringWriter();
		IOUtils.copy(mainInputStream, mainWriter);
		String mainTemplate = mainWriter.toString();
		
		mainTemplate = mainTemplate.replace("{subjectText}", subject);
		mainTemplate = mainTemplate.replace("{textColor}", application.getColor());
		mainTemplate = mainTemplate.replace("{backgroundColor}", application.getBackground());
		//mainTemplate = mainTemplate.replace("{pictureUrl}", String.format("%simg/logo/%s-email.jpg", Configuration.getWebServerUrl(), application));
		
		return mainTemplate;
	}

	public void sendActivationMail(String email, String activationCode, Application application) throws TechnicalException {
		try {
			InputStream activateAccountInputStream = getClass().getResourceAsStream("/com/epiforum/server/logic/mail/template/activateAccount.html");
			StringWriter activateAccountWriter = new StringWriter();
			IOUtils.copy(activateAccountInputStream, activateAccountWriter);
			String activateAccountTemplate = activateAccountWriter.toString();
			
			// Set the activation url, title and body for email
			String activationUrl = String.format(Configuration.getActivationUrl(), email, activationCode);
			activateAccountTemplate = activateAccountTemplate.replace("{activationUrl}", activationUrl);

			String welcomeText = I18n.getMessage(MessageKey.EMAIL_ACTIVATION_CONFIRMATION_CONTENT_TITLE, application.getLocale());
			welcomeText = String.format(welcomeText, application);
			activateAccountTemplate = activateAccountTemplate.replace("{welcomeText}", welcomeText);

			String contentText = I18n.getMessage(MessageKey.EMAIL_ACTIVATION_CONFIRMATION_CONTENT_MESSAGE, application.getLocale());
			contentText = String.format(contentText, email, application);

			activateAccountTemplate = activateAccountTemplate.replace("{contentText}", contentText);
			
			String validateText = I18n.getMessage(MessageKey.EMAIL_ACTIVATION_CONFIRMATION_CONTENT_VALIDATE, application.getLocale());
			activateAccountTemplate = activateAccountTemplate.replace("{validateText}", validateText);
			
			String signatureText = I18n.getMessage(MessageKey.EMAIL_SIGNATURE, application.getLocale());
			signatureText = String.format(signatureText, application, Configuration.getWebServerUrl());
			activateAccountTemplate = activateAccountTemplate.replace("{signatureText}", signatureText);
			
			String mainTemplate = this.getMainTemplate(application, welcomeText);
			mainTemplate = mainTemplate.replace("{body}", activateAccountTemplate);
			String subject = I18n.getMessage(MessageKey.EMAIL_ACTIVATION_CONFIRMATION_CONTENT_SUBJECT, application.getLocale());
			subject = String.format(subject, application);

			MailProperties mailProperties = new MailProperties();
			mailProperties.setFrom(this.getNoReplyEmail(application));
			mailProperties.getTo().add(email);
			mailProperties.setSubject(subject);
			mailProperties.setContent(mainTemplate);

			sendMail(mailProperties);
			System.out.println(String.format("MailManager.sendActivationMail - email: %s", email));
		} catch (Exception exc) {
			throw new TechnicalException(exc);
		}
	}

	public void sendForgotPasswordEmail(String email, String password, Application application) throws TechnicalException {
		try {
			InputStream forgotPasswordInputStream = getClass().getResourceAsStream("/com/cubbyhole/server/logic/mail/template/forgotPassword.html");
			StringWriter forgotPasswordAccountWriter = new StringWriter();
			IOUtils.copy(forgotPasswordInputStream, forgotPasswordAccountWriter);
			String forgotPasswordTemplate = forgotPasswordAccountWriter.toString();

			String titleText = I18n.getMessage(MessageKey.EMAIL_FORGOT_PASSWORD_CONTENT_TITLE, application.getLocale());
			titleText = String.format(titleText, application);
			forgotPasswordTemplate = forgotPasswordTemplate.replace("{titleText}", titleText);

			String contentText = I18n.getMessage(MessageKey.EMAIL_FORGOT_PASSWORD_CONTENT_MESSAGE, application.getLocale());
			String login = "<b>" + email + "</b>";
			password = "<b>" + password + "</b>";
			contentText = String.format(contentText, email, login, password);
			forgotPasswordTemplate = forgotPasswordTemplate.replace("{contentText}", contentText);
			
			String signatureText = I18n.getMessage(MessageKey.EMAIL_SIGNATURE, application.getLocale());
			signatureText = String.format(signatureText, application, Configuration.getWebServerUrl());
			forgotPasswordTemplate = forgotPasswordTemplate.replace("{signatureText}", signatureText);
			
			String mainTemplate = this.getMainTemplate(application, titleText);
			mainTemplate = mainTemplate.replace("{body}", forgotPasswordTemplate);
			String subject = I18n.getMessage(MessageKey.EMAIL_FORGOT_PASSWORD_CONTENT_SUBJECT, application.getLocale());
			subject = String.format(subject, application);

			MailProperties mailProperties = new MailProperties();
			mailProperties.setFrom(this.getNoReplyEmail(application));
			mailProperties.getTo().add(email);
			mailProperties.setSubject(subject);
			mailProperties.setContent(mainTemplate);

			sendMail(mailProperties);
			System.out.println(String.format("MailManager.sendForgotPasswordMail - email: %s", email));
		} catch (Exception exc) {
			throw new TechnicalException(exc);
		}
	}
	
	public String getActivatedAccountHtmlContent(String message, Application application) throws TechnicalException {
		try {
			InputStream activatedAccountInputStream = getClass().getResourceAsStream("/com/epiforum/server/logic/mail/template/activatedAccount.html");
			StringWriter activatedAccountWriter = new StringWriter();
			IOUtils.copy(activatedAccountInputStream, activatedAccountWriter);
			String activatedAccountTemplate = activatedAccountWriter.toString();

			String titleText = I18n.getMessage(MessageKey.EMAIL_ACTIVATION_VALIDATION_TITLE, application.getLocale());
			titleText = String.format(titleText, application);
			activatedAccountTemplate = activatedAccountTemplate.replace("{titleText}", titleText);

			String contentText = I18n.getMessage(MessageKey.EMAIL_ACTIVATION_VALIDATION_MESSAGE, application.getLocale());
			contentText = String.format(contentText, message);
			activatedAccountTemplate = activatedAccountTemplate.replace("{contentText}", contentText);
			
			String signatureText = I18n.getMessage(MessageKey.EMAIL_SIGNATURE, application.getLocale());
			signatureText = String.format(signatureText, application, Configuration.getWebServerUrl());
			activatedAccountTemplate = activatedAccountTemplate.replace("{signatureText}", signatureText);
			
			String mainTemplate = this.getMainTemplate(application, titleText);
			mainTemplate = mainTemplate.replace("{body}", activatedAccountTemplate);
			
			return mainTemplate;
		} catch (Exception exc) {
			throw new TechnicalException(exc);
		}
	}
}