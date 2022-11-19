package com.taskmanager.daoimpl;

import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.taskmanager.dao.ITaskManagerDao;
import com.taskmanager.model.CreateTask;
import com.taskmanager.model.ReturnMessage;
import com.taskmanager.model.Task;

/**
 * The Class TaskManagerDaoImpl.
 */
@Repository("taskManagerDao")
public class TaskManagerDaoImpl implements ITaskManagerDao {

	/** The jdbc template. */
	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * Creates the and assign task.
	 *
	 * @param createTask the create task
	 * @return the int
	 */
	@Override
	public int createAndAssignTask(CreateTask createTask) {
		try {
			return jdbcTemplate.update(TaskManagerQueryConstant.insertIntoTask(), createTask.getManagerID(),
					createTask.getTeamMemberID(), createTask.getStatusCode(), createTask.getDetails(),
					createTask.getComments());
		} catch (Exception e) {
			System.out.print(e);
			return 0;
		}

	}

	/**
	 * Delete task.
	 *
	 * @param taskID the task ID
	 * @return the int
	 */
	@Override
	public int deleteTask(int taskID) {
		try {
			return jdbcTemplate.update(TaskManagerQueryConstant.deleteTask(), taskID);
		} catch (Exception e) {
			System.out.print("Excpetion occured in deleteTask {}".formatted(e));
		}
		return 0;
	}

	/**
	 * Update details.
	 *
	 * @param taskID the task ID
	 * @param details the details
	 * @return the int
	 */
	@Override
	public int updateDetails(int taskID, String details) {
		try {
			return jdbcTemplate.update(TaskManagerQueryConstant.updateDetails(), details, taskID);
		} catch (Exception e) {
			System.out.print("Excpetion occured in deleteTask {}".formatted(e));
		}
		return 0;
	}

	/**
	 * Gets the tasks.
	 *
	 * @param teamMemberID the team member ID
	 * @return the tasks
	 */
	@SuppressWarnings("deprecation")
	@Override
	public List<Task> getTasks(int teamMemberID, String status) {

		try {
			Object[] params = new Object[] { teamMemberID };
			StringBuilder query = TaskManagerQueryConstant.getTasks();
			if (status != null) {
				query.append(" AND STYPE.Code =  ? ");
				params = new Object[] { teamMemberID, status };
			}

			return jdbcTemplate.query(query.toString(), params, (rs, rowNum) -> {
				Task task = new Task();
				task.setTaskID(rs.getInt("TaskID"));
				task.setManager(rs.getString("Manager"));
				task.setTeamMember(rs.getString("Member"));
				task.setStatus(rs.getString("Status"));
				task.setDetails(rs.getString("Details"));
				task.setComments(rs.getString("Comments"));
				return task;
			});
		} catch (Exception exception) {
			System.out.print(exception);
			return Collections.EMPTY_LIST;
		}
	}
	
	@Override
	public int updateStatusAndComments(int taskID, String statsuCode, String comments) {
		try {
			return jdbcTemplate.update(TaskManagerQueryConstant.updateStatusAndComments(), comments, statsuCode,
					taskID);
		} catch (Exception e) {
			System.out.print(e);
		}
		return 0;
	}
}
