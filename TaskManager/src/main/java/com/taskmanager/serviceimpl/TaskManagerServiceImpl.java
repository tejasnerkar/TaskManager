package com.taskmanager.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.taskmanager.CommonUtillity;
import com.taskmanager.dao.ITaskManagerDao;
import com.taskmanager.model.CreateTask;
import com.taskmanager.model.ReturnMessage;
import com.taskmanager.model.Task;
import com.taskmanager.service.ITaskManagerService;

/**
 * The Class TaskManagerServiceImpl.
 */
@Service("ITaskManagerService")
public class TaskManagerServiceImpl implements ITaskManagerService {

	/** The task manager dao. */
	@Autowired
	ITaskManagerDao taskManagerDao;

	/**
	 * Creates the and assign task.
	 *
	 * @param createTask the create task
	 * @return the return message
	 */
	@Override
	public ReturnMessage createAndAssignTask(CreateTask createTask) {
		int updated = taskManagerDao.createAndAssignTask(createTask);
		if (updated > 0) {
			return CommonUtillity.getResponse(HttpStatus.OK, "Task Created", 1);
		} else {
			return CommonUtillity.getResponse(HttpStatus.NOT_FOUND, "Task Not Created", 0);

		}
	}

	/**
	 * Delete task.
	 *
	 * @param taskID the task ID
	 * @return the return message
	 */
	@Override
	public ReturnMessage deleteTask(int taskID) {
		int deleted = taskManagerDao.deleteTask(taskID);
		if (deleted > 0) {
			return CommonUtillity.getResponse(HttpStatus.OK, "Task Deleted", 1);
		} else
			return CommonUtillity.getResponse(HttpStatus.NOT_MODIFIED, "Task Not Deleted", 1);

	}

	/**
	 * Gets the tasks.
	 *
	 * @param teamMemberID the team member ID
	 * @return the tasks
	 */
	@Override
	public ReturnMessage getTasks(int teamMemberID,String status) {
		List<Task> tasks = taskManagerDao.getTasks(teamMemberID,status);
		if (tasks.isEmpty()) {
			return CommonUtillity.getResponse(HttpStatus.NOT_FOUND, "No Tasks Found", null);
		} else {
			return CommonUtillity.getResponse(HttpStatus.OK, "Tasks Found", tasks);
		}

	}

	/**
	 * Update details.
	 *
	 * @param taskID  the task ID
	 * @param details the details
	 * @return the return message
	 */
	@Override
	public ReturnMessage updateDetails(int taskID, String details) {
		int updated = taskManagerDao.updateDetails(taskID, details);
		if (updated > 0) {
			return CommonUtillity.getResponse(HttpStatus.OK, "Details Updated", 1);
		} else {
			return CommonUtillity.getResponse(HttpStatus.NOT_MODIFIED, "Details Not Updated", 0);
		}

	}

	@Override
	public ReturnMessage updateStatusAndComments(int taskID, String statsuCode,String comments) {
		int updated = taskManagerDao.updateStatusAndComments(taskID, statsuCode, comments);
		if(updated > 0) {
			return CommonUtillity.getResponse(HttpStatus.OK, "Status Updated", 1);
		}
		else {
			return CommonUtillity.getResponse(HttpStatus.NOT_MODIFIED, "Status not Updated", 1);
		}
	}

}
