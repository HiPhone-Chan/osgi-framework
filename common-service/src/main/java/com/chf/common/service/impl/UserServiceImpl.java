package com.chf.common.service.impl;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import com.chf.common.core.domain.User;
import com.chf.common.core.persistence.UserDao;
import com.chf.common.core.service.UserService;

@Named("userService")
public class UserServiceImpl implements UserService {

	@Inject
	private UserDao userDao;

	@PostConstruct
	public void init() {
		System.out.println("start up ---------------------");
	}

	@Override
	public Collection<User> getUsers() {
		return userDao.getAll();
	}
}
