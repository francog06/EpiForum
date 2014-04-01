package com.epiforum.server.logic.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;

import com.epiforum.common.ro.TopicRO;
import com.epiforum.server.config.i18n.I18n;
import com.epiforum.server.config.i18n.I18n.MessageKey;
import com.epiforum.server.config.properties.Configuration;
import com.epiforum.server.logic.exception.BadCredentialException;
import com.epiforum.server.logic.exception.BadParametersException;

@Stateless
public class ModerationFacade extends OperationFacade {

						/*	TOPIC STUFF	*/

	public void			updateTopic(HttpServletRequest request, String token, TopicRO topicRo) throws BadCredentialException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Configuration.getDefaultLocale()));
		}
	}

	public void			deleteTopic(HttpServletRequest request, String token, Integer topicId) throws BadCredentialException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Configuration.getDefaultLocale()));
		}
	}
	
	public void			moveTopic(HttpServletRequest request, String token, Integer boardId) throws BadCredentialException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Configuration.getDefaultLocale()));
		}
	}
	
	public void			mergeTopics(HttpServletRequest request, String token, List<Integer> topicsId) throws BadCredentialException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Configuration.getDefaultLocale()));
		}
	}
}