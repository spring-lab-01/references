package com.hk.prj.seedsm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Row extends BaseEntity{

	@ManyToOne
	@JoinColumn(name="variety_id")
	private Variety variety;
	
	private Integer seedsPerCell;
	
}
