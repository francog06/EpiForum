package com.epiforum.server.logic.manager;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.epiforum.common.ro.TopicRO;
import com.epiforum.server.config.i18n.I18n;
import com.epiforum.server.config.i18n.I18n.MessageKey;
import com.epiforum.server.config.properties.Configuration;
import com.epiforum.server.data.entity.Board;
import com.epiforum.server.data.entity.Topic;
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
			throw new BadParametersException(String.format(I18n.getMessage(MessageKey.ERROR_PARAMETER_REQUIRED, Configuration.getDefaultLocale()), "Titre"));
		}
		Topic topic = new Topic(board, topicRo.getTitle().trim(), topicRo.getDescription().trim(), topicRo.getLocked());
		this.topicDao.saveTopic(topic);
		return topic;
	}
	
	public Boolean				updateTopic(TopicRO topicRo, Topic topic) {
		boolean modified = false;
		if (topicRo.getTitle() != null && !topicRo.getTitle().trim().isEmpty()) {
			topic.setTitle(topicRo.getTitle().trim());
			modified = true;
		}
		if (topicRo.getDescription() != null && !topicRo.getDescription().trim().isEmpty()) {
			topic.setDescription(topicRo.getDescription().trim());
			modified = true;
		}
		if (topicRo.getLocked() != null) {
			topic.setLocked(topicRo.getLocked());
			modified = true;
		}
		return modified;
	}

	public Integer				countTopics() {
		return this.topicDao.countTopics();
	}

	public List<Topic>			getAllTopicsFromBoardId(Integer boardId) {
		return this.topicDao.getAllTopicsFromBoardId(boardId);
	}

	public List<Topic>			getTopTopics(Integer number) {
		return this.topicDao.getTopTopics(number);
	}
	
	public void					deleteTopic(Topic topic) {
		this.topicDao.deleteTopic(topic);
	}
}
