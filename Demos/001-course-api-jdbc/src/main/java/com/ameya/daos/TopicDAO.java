package com.ameya.daos;

import java.util.List;

import com.ameya.models.Topic;

public interface TopicDAO {
	List<Topic> getAllTopics();
	void addTopic(Topic topic);
	void updateTopic(String id,Topic topic);
	Topic getTopic(String id);
	void deleteTopic(String id);
	
}
