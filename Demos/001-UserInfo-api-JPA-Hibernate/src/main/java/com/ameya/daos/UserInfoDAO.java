package com.ameya.daos;

import java.util.List;

import com.ameya.models.UserInfo;

public interface UserInfoDAO {
	public void addUser(UserInfo userInfo);
	public List<UserInfo> getAllUsersInfo();
	public UserInfo findById(int id);
	public UserInfo update(UserInfo userInfo, int id);
	public void delete(int id);
}
