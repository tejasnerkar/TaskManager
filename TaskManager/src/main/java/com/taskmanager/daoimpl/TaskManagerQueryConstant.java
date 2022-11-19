package com.taskmanager.daoimpl;

/**
 * The Class TaskManagerQueryConstant.
 */
public class TaskManagerQueryConstant {
	
	/**
	 * Insert into task.
	 *
	 * @return the string
	 */
	public static String insertIntoTask() {
		StringBuilder query =  new StringBuilder();
		query.append(" INSERT INTO \"Task\"(TaskID, CreatedBy, AssignedTo, StatusTypeID, Details, Comments) ");
		query.append(" VALUES((SELECT Max(TaskID)+1 FROM \"Task\"),?,?,(SELECT StatusTypeID FROM \"StatusType\" WHERE Code = ?),?,?) ");
		return query.toString();
	}
	
	/**
	 * Delete task.
	 *
	 * @return the string
	 */
	public static String deleteTask() {
		StringBuilder query =  new StringBuilder();
		query.append(" DELETE FROM \"Task\" WHERE TaskID = ? ");
		return query.toString();
	}
	
	/**
	 * Update details.
	 *
	 * @return the string
	 */
	public static String updateDetails() {
		StringBuilder query =  new StringBuilder();
		query.append(" UPDATE \"Task\" ");
		query.append(" SET Details = ? ");
		query.append(" WHERE TaskID = ? ");
		return query.toString();
	}
	
	public static String updateStatusAndComments() {
		StringBuilder query =  new StringBuilder();
		query.append(" UPDATE \"Task\" ");
		query.append(" SET Comments = ?, ");
		query.append(" StatusTypeID = (SELECT StatusTypeID FROM \"StatusType\" WHERE Code  = ? ) ");
		query.append(" WHERE TaskID = ? ");
		return query.toString();
	}
	
	/**
	 * Gets the tasks.
	 *
	 * @return the tasks
	 */
	public static StringBuilder getTasks() {
		StringBuilder query =  new StringBuilder();
		query.append(" SELECT Taskid AS \"TaskID\", TEAMMMBR.UserName AS \"Manager\", ");
		query.append(" MNG.UserName AS \"Member\", STYPE.Name AS \"Status\", ");
		query.append(" Details AS \"Details\", Comments AS \"Comments\" ");
		query.append(" FROM \"Task\" \"TASK\" ");
		query.append(" INNER JOIN \"User\" TEAMMMBR ");
		query.append(" ON TASK.AssignedTo = TEAMMMBR.UserID ");
		query.append(" INNER JOIN \"User\" MNG ");
		query.append(" ON TASK.CreatedBy= MNG.UserID ");
		query.append(" INNER JOIN \"StatusType\" STYPE ");
		query.append(" ON TASK.StatusTypeID = STYPE.StatusTypeID ");
		query.append(" WHERE TASK.AssignedTo = ? ");
		return query;
	} 

}
