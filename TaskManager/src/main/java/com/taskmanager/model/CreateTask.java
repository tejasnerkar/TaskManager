package com.taskmanager.model;

public class CreateTask {
	private int managerID;
	
	private int teamMemberID;
	
	private String statusCode;
	
	private String details;
	
	private String comments;

	public int getManagerID() {
		return managerID;
	}

	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}

	public int getTeamMemberID() {
		return teamMemberID;
	}

	public void setTeamMemberID(int teamMemberID) {
		this.teamMemberID = teamMemberID;
	}


	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
	

}
