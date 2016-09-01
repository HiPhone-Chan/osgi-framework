package com.chf.common.persistence.impl;

import org.osgi.service.component.annotations.Component;

import com.chf.common.core.domain.Task;
import com.chf.common.core.persistence.TaskDao;

@Component
public class TaskDaoImpl extends MemDao<Task, String> implements TaskDao {

	public TaskDaoImpl() {
		Task task = new Task("1", "Buy some coffee");
		update(task);
		task = new Task("2", "Buy some cookie");
		update(task);
	}

	@Override
	public void update(Task model) {
		storeMap.put(model.getId(), model);
	}

}
