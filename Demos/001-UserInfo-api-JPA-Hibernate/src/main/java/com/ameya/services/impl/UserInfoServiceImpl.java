package com.ameya.services.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ameya.daos.UserInfoDAO;
import com.ameya.models.UserInfo;
import com.ameya.services.UserInfoService;

@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	private UserInfoDAO userInfoDao;

	@Override
	public void createUserInfo(UserInfo userInfo) {
		userInfoDao.addUser(userInfo);
	}
	@Override
	public List<UserInfo> getAllUsersInfo() {
		return userInfoDao.getAllUsersInfo();
	}
	@Override
	public UserInfo findById(int id) {
		return userInfoDao.findById(id);
	}
	@Override
	public UserInfo update(UserInfo userInfo, int id) {
		return userInfoDao.update(userInfo, id);
	}
	@Override
	public void deleteUserInfoById(int id) {
		userInfoDao.delete(id);
	}
}
