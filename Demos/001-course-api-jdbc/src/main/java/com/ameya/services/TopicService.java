package com.ameya.services;

import java.util.List;

import com.ameya.models.Topic;

public interface TopicService {

	List<Topic> getAllTopics();
	public void addTopic(Topic topic);
	public void updateTopic(String id,Topic topic);
	public Topic getTopic(String id);
	public void deleteTopic(String id);
}
