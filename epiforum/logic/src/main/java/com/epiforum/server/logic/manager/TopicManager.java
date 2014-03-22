package com.epiforum.server.logic.manager;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.epiforum.server.logic.dao.TopicDao;

@Stateless
public class TopicManager {

	@EJB
	private TopicDao			topicDao;
}
