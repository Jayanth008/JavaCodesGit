package com.bookauthor.service;

import com.bookauthor.entity.UserInfo;

public interface SecurityInterface {

	String adduser(UserInfo userInfo);

	void saveuser(UserInfo userInfo);

	boolean userExists(String userName);

}
