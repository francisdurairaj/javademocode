package com.ameya.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ameya.daos.TopicDAO;
import com.ameya.models.Topic;
import com.ameya.services.TopicService;

@Service
public class TopicServiceImpl implements TopicService {
	
	@Autowired
	private TopicDAO topicDao;

	@Override
	public List<Topic> getAllTopics() {
		return topicDao.getAllTopics();
	}

	@Override
	public void addTopic(Topic topic) {
		topicDao.addTopic(topic);
	}

	@Override
	public void updateTopic(String id, Topic topic) {
		topicDao.updateTopic(id, topic);
	}

	@Override
	public Topic getTopic(String id) {
		return topicDao.getTopic(id);
	}

	@Override
	public void deleteTopic(String id) {
		topicDao.deleteTopic(id);
	}

}
