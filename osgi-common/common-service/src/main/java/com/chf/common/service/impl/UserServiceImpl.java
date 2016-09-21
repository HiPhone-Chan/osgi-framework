package com.chf.common.service.impl;

import java.util.Collection;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.chf.common.core.domain.User;
import com.chf.common.core.persistence.UserDao;
import com.chf.common.core.service.UserService;

@Component(service = { UserService.class })
public class UserServiceImpl implements UserService {

	@Reference
	private UserDao userDao;

	@Override
	public Collection<User> getUsers() {
		return userDao.getAll();
	}
}
