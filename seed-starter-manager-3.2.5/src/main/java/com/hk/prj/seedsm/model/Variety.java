package com.hk.prj.seedsm.model;

import jakarta.persistence.Entity;



@Entity
public class Variety extends BaseEntity{

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
