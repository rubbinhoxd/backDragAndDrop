package com.rav_tecnologia.desafio.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ACTIVITY")
public class Activity implements Serializable {
	private static final long serialVersionUID = 1L;

	// creating table
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idActivity")
	@SequenceGenerator(name = "idActivity", sequenceName = "SQ_ACTIVITY", allocationSize = 1)
	private Long id;
	@Column(nullable = false, length = 150)
	private String nameOfActivity;
	@Column(nullable = true)
	private Date dateOfActivity;
	@Column(nullable = true)
	private Boolean checkList;

	@ManyToOne
	@JoinColumn(name = "id_group")
	private Group group;

	public void setGroup(Group group) {
		this.group = group;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameOfActivity() {
		return nameOfActivity;
	}

	public void setNameOfActivity(String nameOfActivity) {
		this.nameOfActivity = nameOfActivity;
	}

	public Date getDateOfActivity() {
		return dateOfActivity;
	}

	public void setDateOfActivity(Date dateOfActivity) {
		this.dateOfActivity = dateOfActivity;
	}

	public Boolean getCheckList() {
		return checkList;
	}

	public void setCheckList(Boolean checkList) {
		this.checkList = checkList;
	}

	
	
}
