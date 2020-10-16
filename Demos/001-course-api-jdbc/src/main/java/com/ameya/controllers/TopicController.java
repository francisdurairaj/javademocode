package com.ameya.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ameya.models.Topic;
import com.ameya.services.TopicService;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@GetMapping(path="/topics")
	public List<Topic> getAllTopics(){
		return topicService.getAllTopics();
	}
	@GetMapping(path="/topics/{id}")
	public Topic getTopic(@PathVariable("id") String id) {
		return topicService.getTopic(id);
	}
	@PostMapping(path="/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	@PutMapping(path="/topics/{id}")
	public void updateTopic(@PathVariable String id,@RequestBody Topic topic) {
		topicService.updateTopic(id, topic);
	}
	@DeleteMapping(path="/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
}
