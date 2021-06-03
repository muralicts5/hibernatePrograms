package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Project {

	@Id
	private int id;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVertical() {
		return vertical;
	}
	public void setVertical(String vertical) {
		this.vertical = vertical;
	}
	private String vertical;
}
