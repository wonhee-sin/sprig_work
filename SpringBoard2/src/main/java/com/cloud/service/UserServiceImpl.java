package com.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.cloud.domain.UserVO;
import com.cloud.mapper.UserMapper;

@Primary
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper mapper;

	@Override
	public boolean login(UserVO vo) {
		return mapper.login(vo);
	}

	
	
}
