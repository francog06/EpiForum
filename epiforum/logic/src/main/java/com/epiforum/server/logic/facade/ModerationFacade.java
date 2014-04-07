package com.epiforum.server.logic.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;

import com.epiforum.common.ro.TopicRO;
import com.epiforum.server.config.i18n.I18n;
import com.epiforum.server.config.i18n.I18n.MessageKey;
import com.epiforum.server.config.properties.Configuration;
import com.epiforum.server.data.entity.Account.Type;
import com.epiforum.server.data.entity.Board;
import com.epiforum.server.data.entity.Post;
import com.epiforum.server.data.entity.Session;
import com.epiforum.server.data.entity.Topic;
import com.epiforum.server.logic.exception.BadCredentialException;
import com.epiforum.server.logic.exception.BadParametersException;

@Stateless
public class ModerationFacade extends OperationFacade {

							/*	TOPIC STUFF	*/

	public Boolean				updateTopic(HttpServletRequest request, String token, TopicRO topicRo) throws BadCredentialException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Configuration.getDefaultLocale()));
		}
		if (topicRo == null || topicRo.getId() == null) {
			throw new BadParametersException(I18n.getMessage(MessageKey.ERROR_PARAMETER_DEFAULT, Configuration.getDefaultLocale()));
		}
		Session se = this.sessionManager.getSession(token);
		if (!this.checkAccountType(se, Type.MODERATEUR)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_FORBIDEN, Configuration.getDefaultLocale()));
		}
		
		Topic topic = this.topicManager.getTopicFromId(topicRo.getId());
		if (topic != null) {
			return this.topicManager.updateTopic(topicRo, topic);
		}
		return false;
	}

	public Boolean			deleteTopic(HttpServletRequest request, String token, Integer topicId) throws BadCredentialException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Configuration.getDefaultLocale()));
		}
		if (topicId == null || topicId == 0) {
			throw new BadParametersException(I18n.getMessage(MessageKey.ERROR_PARAMETER_DEFAULT, Configuration.getDefaultLocale()));
		}
		Session se = this.sessionManager.getSession(token);
		if (!this.checkAccountType(se, Type.MODERATEUR)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_FORBIDEN, Configuration.getDefaultLocale()));
		}
		
		Topic topic = this.topicManager.getTopicFromId(topicId);
		if (topic != null) {
			List<Post> posts = topic.getPosts();
			for (Post post : posts) {
				this.contentPostManager.removeContentPost(post.getContentPost());
				/*NEVER USE IT*/
				this.postManager.deletePost(post);
			}
			this.topicManager.removeTopic(topic);
			return true;
		}
		return false;
	}
	
	public Boolean			moveTopic(HttpServletRequest request, String token, Integer topicId, Integer boardId) throws BadCredentialException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Configuration.getDefaultLocale()));
		}
		if (boardId == null || boardId == 0) {
			throw new BadParametersException(I18n.getMessage(MessageKey.ERROR_PARAMETER_DEFAULT, Configuration.getDefaultLocale()));
		}
		Session se = this.sessionManager.getSession(token);
		if (!this.checkAccountType(se, Type.MODERATEUR)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_FORBIDEN, Configuration.getDefaultLocale()));
		}
		
		Board board = this.boardManager.getBoardFromId(boardId);
		Topic topic = this.topicManager.getTopicFromId(topicId);
		if (board != null && topic != null) {
			topic.setBoard(board);
			return true;
		}
		return false;
	}
	
	public void			mergeTopics(HttpServletRequest request, String token, List<Integer> topicsId) throws BadCredentialException, BadParametersException {
		if (!this.checkSession(token)) {
			throw new BadCredentialException(I18n.getMessage(MessageKey.ERROR_CREDENTIAL_LOGIN, Configuration.getDefaultLocale()));
		}
	}
}