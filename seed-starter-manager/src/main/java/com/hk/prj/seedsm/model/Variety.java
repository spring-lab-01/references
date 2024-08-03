package com.hk.prj.seedsm.model;

import jakarta.persistence.Entity;

import lombok.Data;


@Data
@Entity
public class Variety extends BaseEntity{

	private String name;
	
}
