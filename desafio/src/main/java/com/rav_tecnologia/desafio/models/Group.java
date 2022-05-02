package com.rav_tecnologia.desafio.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_GROUP")
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	//creating table
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGroup")
	@SequenceGenerator(name = "idGroup", sequenceName = "SQ_GROUP", allocationSize = 1)
	private Long id;
	@Column(nullable = false, length = 50)
	private String nameOfGroup;
	
	@OneToMany(mappedBy = "group", cascade = CascadeType.ALL) //mapeando o grupo
	private List<Activity> activities;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNameOfGroup() {
		return nameOfGroup;
	}
	public void setNameOfGroup(String nameOfGroup) {
		this.nameOfGroup = nameOfGroup;
	}
	public List<Activity> getActivities() {
		return activities;
	}
	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	
	
	
}















