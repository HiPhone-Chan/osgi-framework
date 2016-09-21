package com.chf.ui.web.rest;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.ops4j.pax.cdi.api.OsgiService;

import com.chf.common.core.domain.Task;
import com.chf.common.core.service.TaskService;
import com.chf.ui.dto.TaskDto;

@Named
@Path("/task")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public class TaskServiceRest {

	@OsgiService
	@Inject
	private TaskService taskService;

	@Context
	private UriInfo uri;

	@GET
	@Path("{id}")
	public Response getTask(@PathParam("id") String id) {
		Task task = taskService.getTask(id);
		return task == null ? Response.status(Status.NOT_FOUND).build() : Response.ok(new TaskDto(task)).build();
	}

	@POST
	public Response addTask(Task task) {
		taskService.addTask(task);
		URI taskURI = uri.getRequestUriBuilder().path(TaskServiceRest.class, "getTask").build(task.getId());
		return Response.created(taskURI).build();
	}

	@GET
	public Collection<TaskDto> getTasks() {
		return taskService.getTasks().stream().map(task -> new TaskDto(task))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	@PUT
	@Path("{id}")
	public void updateTask(@PathParam("id") String id, Task task) {
		task.setId(id);
		taskService.updateTask(task);
	}

	@DELETE
	@Path("{id}")
	public void deleteTask(@PathParam("id") String id) {
		taskService.deleteTask(id);
	}

}
