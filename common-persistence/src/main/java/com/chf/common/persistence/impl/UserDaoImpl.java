package com.chf.common.persistence.impl;

import org.osgi.service.component.annotations.Component;

import com.chf.common.core.domain.User;
import com.chf.common.core.persistence.UserDao;

@Component
public class UserDaoImpl extends MemDao<User, String> implements UserDao {

	public UserDaoImpl() {
		User user = new User("Mike");
		update(user);
		user = new User("John");
		update(user);
	}

	@Override
	public void update(User model) {
		storeMap.put(model.getId(), model);
	}

}
