package com.chf.common.persistence.impl;

import javax.inject.Named;

import org.ops4j.pax.cdi.api.OsgiServiceProvider;
import org.ops4j.pax.cdi.api.Properties;
import org.ops4j.pax.cdi.api.Property;

import com.chf.common.core.domain.Task;
import com.chf.common.core.persistence.TaskDao;

@OsgiServiceProvider(classes = { TaskDao.class })
@Properties({ @Property(name = "service.exported.interfaces", value = "*") })
@Named
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
