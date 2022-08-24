package com.spring.user.impl;

import com.spring.user.UserService;
import com.spring.user.UserVO;

public class UserServiceImpl implements UserService {
	
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public boolean login(UserVO vo) {
		return userDAO.login(vo);
	}

}
