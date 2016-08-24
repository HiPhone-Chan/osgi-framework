package com.chf.common.persistence.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

import com.chf.common.core.domain.Task;
import com.chf.common.core.persistence.TaskDao;

@Component
public class TaskDaoImpl implements TaskDao {

	private Map<String, Task> taskMap;

	public TaskDaoImpl() {
		taskMap = new HashMap<String, Task>();
		Task task = new Task();
		task.setId("1");
		task.setTitle("Buy some coffee");
		task.setDescription("Take the extra strong");
		taskMap.put(task.getId(), task);
		task = new Task();
		task.setId("2");
		task.setTitle("Finish karaf tutorial");
		task.setDescription("Last check and wiki upload");
		taskMap.put(task.getId(), task);
	}

	@Override
	public Task get(String id) {
		return taskMap.get(id);
	}

	@Override
	public void add(Task task) {
		taskMap.put(task.getId(), task);
	}

	@Override
	public Collection<Task> getAll() {
		return new ArrayList<Task>(taskMap.values());
	}

	@Override
	public void update(Task task) {
		taskMap.put(task.getId(), task);
	}

	@Override
	public void delete(String id) {
		taskMap.remove(id);
	}

}
