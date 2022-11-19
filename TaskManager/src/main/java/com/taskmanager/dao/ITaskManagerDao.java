package com.taskmanager.dao;

import java.util.List;

import com.taskmanager.model.CreateTask;
import com.taskmanager.model.ReturnMessage;
import com.taskmanager.model.Task;

/**
 * The Interface ITaskManagerDao.
 */
public interface ITaskManagerDao {

	/**
	 * Creates the and assign task.
	 *
	 * @param createTask the create task
	 * @return the int
	 */
	public int createAndAssignTask(CreateTask createTask);

	/**
	 * Delete task.
	 *
	 * @param taskID the task ID
	 * @return the int
	 */
	public int deleteTask(int taskID);

	/**
	 * Update details.
	 *
	 * @param taskID the task ID
	 * @param details the details
	 * @return the int
	 */
	public int updateDetails(int taskID, String details);

	/**
	 * Gets the tasks.
	 *
	 * @param teamMemberID the team member ID
	 * @return the tasks
	 */
	public List<Task> getTasks(int teamMemberID,String status);
	
	/**
	 * Update task status.
	 *
	 * @return the return message
	 */
	public int updateStatusAndComments(int taskID, String statsuCode,String comments);
}
