package com.taskmanager.taskcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.taskmanager.model.CreateTask;
import com.taskmanager.model.ReturnMessage;
import com.taskmanager.service.ITaskManagerService;

/**
 * The Class Taskcontroller.
 */
@RestController
public class Taskcontroller {

	/** The task manager service. */
	@Autowired
	ITaskManagerService taskManagerService;

	/**
	 * Creates the and assign task.
	 *
	 * @param createTask the create task
	 * @return the return message
	 */
	@PostMapping("api/createTask")
	public ReturnMessage createAndAssignTask(@RequestBody CreateTask createTask) {
		return taskManagerService.createAndAssignTask(createTask);

	}

	/**
	 * Delete task.
	 *
	 * @param taskID the task ID
	 * @return the return message
	 */
	@PostMapping("api/deleteTask/{taskID}")
	public ReturnMessage deleteTask(@PathVariable int taskID) {
		return taskManagerService.deleteTask(taskID);

	}

	/**
	 * Update details.
	 *
	 * @param taskID the task ID
	 * @param details the details
	 * @return the return message
	 */
	@PutMapping("api/updateDetails/{taskID}")
	public ReturnMessage updateDetails(@PathVariable int taskID, @RequestBody String details) {
		return taskManagerService.updateDetails(taskID, details);

	}

	/**
	 * Gets the tasks.
	 *
	 * @param teamMemberID the team member ID
	 * @return the tasks
	 */
	@GetMapping("api/getAssignedTasks/{teamMemberID}")
	public ReturnMessage getTasks(@PathVariable int teamMemberID,
			@RequestParam(value ="status", required = false) String status
			) {
		return taskManagerService.getTasks(teamMemberID,status);
	}
	
	/**
	 * Update status and comments.
	 *
	 * @param taskID the task ID
	 * @param status the status
	 * @return the return message
	 */
	@PutMapping("api/updateStatus/{taskID}/{statusCode}")
	public ReturnMessage updateStatusAndComments(@PathVariable String statusCode, @PathVariable int taskID,
			@RequestBody String comments) {
		return taskManagerService.updateStatusAndComments(taskID, statusCode, comments);

	}

}
