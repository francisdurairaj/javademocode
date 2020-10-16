package com.ameya.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ameya.models.Topic;
import com.ameya.services.TopicService;

@Service
public class TopicServiceImpl implements TopicService {
	
	private List<Topic>topics=new ArrayList<>(Arrays.asList(
			new Topic("T001", "Spring Framework", "A short Introduction to Spring framework"),
			new Topic("T002", "Java 8", "A short Introduction to Java Programming"),
			new Topic("T003", "Advanced Spring", "A 3 day Advanced Spring framework Course"),
			new Topic("T004", "JEE", "A short Introduction to Java Enterprise Edition")
			));

	@Override
	public List<Topic> getAllTopics() {	
		return topics;
	}

	@Override
	public void addTopic(Topic topic) {
		topics.add(topic);

	}

	@Override
	public void updateTopic(String id, Topic topic) {
		for(int indx=0;indx<topics.size();indx++) {
			Topic t=topics.get(indx);
			if(t.getId().equalsIgnoreCase(id)) {
				topics.set(indx, topic);
				return;
			}
		}

	}

	@Override
	public Topic getTopic(String id) {
		Topic topic=null;
		for(int indx=0;indx<topics.size();indx++) {
			Topic t=topics.get(indx);
			if(t.getId().equalsIgnoreCase(id)) {
				topic=t;
				break;
			}
		}
		return topic;
	}

	@Override
	public void deleteTopic(String id) {
		for(int indx=0;indx<topics.size();indx++) {
			Topic t=topics.get(indx);
			if(t.getId().equalsIgnoreCase(id)) {
				topics.remove(indx);
				return;
			}
		}

	}

}
