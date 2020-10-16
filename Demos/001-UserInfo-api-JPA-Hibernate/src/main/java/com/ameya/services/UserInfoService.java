package com.ameya.services;

import java.util.List;

import com.ameya.models.UserInfo;

public interface UserInfoService {
	public void createUserInfo(UserInfo userInfo);
	public List<UserInfo> getAllUsersInfo();
	public UserInfo findById(int id);
	public UserInfo update(UserInfo userInfo, int id);
	public void deleteUserInfoById(int id);
}
