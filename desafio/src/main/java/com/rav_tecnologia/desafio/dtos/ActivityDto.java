package com.rav_tecnologia.desafio.dtos;

import java.util.Date;

public class ActivityDto {

	
	private String nameOfActivity;
	
	private Long idGroup; //foreing key
	
	private Date dateOfActivity;
	
	private Boolean checkList;

	public String getNameOfActivity() {
		return nameOfActivity;
	}

	public void setNameOfActivity(String nameOfActivity) {
		this.nameOfActivity = nameOfActivity;
	}

	public Long getIdGroup() {
		return idGroup;
	}

	public void setIdGroup(Long idGroup) {
		this.idGroup = idGroup;
	}

	public Date getDateOfActivity() {
		return dateOfActivity;
	}

	public void setDateOfActivity(Date dateOfActivity) {
		this.dateOfActivity = dateOfActivity;
	}

	public Boolean getChecklist() {
		return checkList;
	}

	public void setCheckList(Boolean checkList) {
		this.checkList = checkList;
	}

	
	
}
