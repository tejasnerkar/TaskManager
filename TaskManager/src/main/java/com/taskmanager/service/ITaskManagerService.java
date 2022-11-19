package com.taskmanager.service;

import com.taskmanager.model.CreateTask;
import com.taskmanager.model.ReturnMessage;

/**
 * The Interface ITaskManagerService.
 */
public interface ITaskManagerService {
	
	/**
	 * Creates the and assign task.
	 *
	 * @param createTask the create task
	 * @return the return message
	 */
	public ReturnMessage createAndAssignTask(CreateTask createTask);
	
	/**
	 * Delete task.
	 *
	 * @param taskID the task ID
	 * @return the return message
	 */
	public ReturnMessage deleteTask(int taskID);
	
	/**
	 * Update details.
	 *
	 * @param taskID the task ID
	 * @param details the details
	 * @return the return message
	 */
	public ReturnMessage updateDetails(int taskID,String details);
	
	/**
	 * Gets the tasks.
	 *
	 * @param teamMemberID the team member ID
	 * @return the tasks
	 */
	public ReturnMessage getTasks(int teamMemberID,String status);
	
	/**
	 * Update task status.
	 *
	 * @return the return message
	 */
	public ReturnMessage updateStatusAndComments(int taskID, String statsuCode,String comments);
	
}
