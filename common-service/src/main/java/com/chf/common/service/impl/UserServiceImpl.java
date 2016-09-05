package com.chf.common.service.impl;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.ops4j.pax.cdi.api.OsgiServiceProvider;
import org.ops4j.pax.cdi.api.Properties;
import org.ops4j.pax.cdi.api.Property;

import com.chf.common.core.domain.User;
import com.chf.common.core.persistence.UserDao;
import com.chf.common.core.service.UserService;

@OsgiServiceProvider(classes = { UserService.class })
@Properties({ @Property(name = "service.exported.interfaces", value = "*") })
@Named("userService")
public class UserServiceImpl implements UserService {

//	@Inject
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
