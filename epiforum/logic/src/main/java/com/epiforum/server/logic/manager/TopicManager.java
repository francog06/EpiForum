package com.epiforum.server.logic.manager;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.epiforum.common.ro.TopicRO;
import com.epiforum.server.config.i18n.I18n;
import com.epiforum.server.config.i18n.I18n.MessageKey;
import com.epiforum.server.data.entity.Board;
import com.epiforum.server.data.entity.Topic;
import com.epiforum.server.logic.application.Application;
import com.epiforum.server.logic.dao.TopicDao;
import com.epiforum.server.logic.exception.BadParametersException;

@Stateless
public class TopicManager {

	@EJB
	private TopicDao			topicDao;

	public Topic				getTopicFromId(Integer id) {
		return this.topicDao.getTopic(id);
	}

	public Topic				createTopic(TopicRO topicRo, Board board) throws BadParametersException {
		if (topicRo.getTitle() == null || topicRo.getTitle().trim().isEmpty()) {
			throw new BadParametersException(String.format(I18n.getMessage(MessageKey.ERROR_PARAMETER_REQUIRED, Application.getLocale()), "Titre"));
		}
		Topic topic = new Topic(board, topicRo.getTitle().trim(), topicRo.getDescription().trim(), topicRo.getLocked());
		this.topicDao.saveTopic(topic);
		return topic;
	}

	public Integer				countTopics() {
		return this.topicDao.countTopics();
	}

	public List<Topic>			getTopTopics(Integer number) {
		return this.topicDao.getTopTopics(number);
	}
}
