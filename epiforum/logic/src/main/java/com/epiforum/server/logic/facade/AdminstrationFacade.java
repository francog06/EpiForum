package com.epiforum.server.logic.facade;

import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;

import com.epiforum.common.ro.BoardRO;
import com.epiforum.common.ro.CategoryRO;
import com.epiforum.common.ro.ProfileInfoRO;
import com.epiforum.server.config.i18n.I18n;
import com.epiforum.server.config.i18n.I18n.MessageKey;
import com.epiforum.server.config.properties.Configuration;
import com.epiforum.server.logic.exception.BadCredentialException;
import com.epiforum.server.logic.exception.BadParametersException;

@Stateless
public class AdminstrationFacade extends ModerationFacade {

						/*	CATEGORY STUFF	*/

	public void			createCategory(HttpServletRequest request, String token, CategoryRO category) throws BadCredentialException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Configuration.getDefaultLocale()));
		}
	}
	
	public void			updateCategory(HttpServletRequest request, String token, CategoryRO category) throws BadCredentialException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Configuration.getDefaultLocale()));
		}
	}
	
	public void			deleteCategory(HttpServletRequest request, String token, Integer categoryId) throws BadCredentialException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Configuration.getDefaultLocale()));
		}
	}

						/*	BOARD STUFF	*/

	public void			createBoard(HttpServletRequest request, String token, BoardRO board) throws BadCredentialException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Configuration.getDefaultLocale()));
		}
	}
	
	public void			updateBoard(HttpServletRequest request, String token, BoardRO board) throws BadCredentialException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Configuration.getDefaultLocale()));
		}
	}
	
	public void			deleteBoard(HttpServletRequest request, String token, Integer boardId) throws BadCredentialException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Configuration.getDefaultLocale()));
		}
	}
	
						/*	PROFILE STUFF	*/
	
	public void			updateProfile(HttpServletRequest request, String token, ProfileInfoRO pro) throws BadCredentialException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Configuration.getDefaultLocale()));
		}
	}
}