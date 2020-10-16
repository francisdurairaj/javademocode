package com.ameya.daos.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ameya.daos.TopicDAO;
import com.ameya.models.Topic;

@Repository
public class TopicDAOImpl implements TopicDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Topic> getAllTopics() {
		final String SQL="select * from topic";
		List<Topic> topics=jdbcTemplate.query(SQL,new RowMapper<Topic>() {
				@Override
				public Topic mapRow(ResultSet rs, int rowNum) throws SQLException{
					Topic topic=new Topic();
					topic.setId(rs.getString("id"));
					topic.setTopicName(rs.getString("topicname"));
					topic.setDescription(rs.getString("description"));
					return topic;
				}
				});
		return topics;
	}

	@Override
	public void addTopic(Topic topic) {
		final String SQL="insert into topic (id,topicname,description) values(?,?,?)";
		jdbcTemplate.update(SQL,topic.getId(),topic.getTopicName(),topic.getDescription());

	}

	@Override
	public void updateTopic(String id, Topic topic) {
		// TODO Auto-generated method stub

	}

	@Override
	public Topic getTopic(String id) {
		final String SQL="select * from topic where id = ?";
		Topic topic=jdbcTemplate.queryForObject(SQL, new Object[] {id},new RowMapper<Topic>(){
			@Override
			public Topic mapRow(ResultSet rs, int rowNum) throws SQLException{
				Topic topic=new Topic();
				topic.setId(rs.getString("id"));
				topic.setTopicName(rs.getString("topicname"));
				topic.setDescription(rs.getString("description"));
				return topic;
			}
			});
		return topic;
	}

	@Override
	public void deleteTopic(String id) {
		// TODO Auto-generated method stub

	}

}
