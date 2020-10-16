package com.ameya.daos.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ameya.daos.UserInfoDAO;
import com.ameya.models.UserInfo;

@Repository
public class UserInfoDAOImpl implements UserInfoDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addUser(UserInfo userInfo) {
		Session session=sessionFactory.getCurrentSession();
		session.save(userInfo);
	}
	@Override
	public List<UserInfo> getAllUsersInfo() {
		Session session=sessionFactory.getCurrentSession();
		List<UserInfo> list=session.createQuery("from UserInfo").list();
		return list;
	}
	@Override
	public UserInfo findById(int id) {
		Session session=sessionFactory.getCurrentSession();
		UserInfo userInfo=(UserInfo)session.get(UserInfo.class, id);
		return userInfo;
	}
	@Override
	public UserInfo update(UserInfo userInfo, int id) {
		Session session = sessionFactory.getCurrentSession();
		UserInfo existingUserInfo=(UserInfo)session.get(UserInfo.class, id);
		existingUserInfo.setName(userInfo.getName());
		existingUserInfo.setCountry(userInfo.getCountry());
		session.update(existingUserInfo);
		return existingUserInfo;
	}
	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		UserInfo userInfo=findById(id);
		session.delete(userInfo);
	}

}
