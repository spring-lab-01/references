package com.hk.prj.seedsm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Row extends BaseEntity{

	@ManyToOne
	@JoinColumn(name="variety_id")
	private Variety variety;
	
	private Integer seedsPerCell;

	public Variety getVariety() {
		return variety;
	}

	public void setVariety(Variety variety) {
		this.variety = variety;
	}

	public Integer getSeedsPerCell() {
		return seedsPerCell;
	}

	public void setSeedsPerCell(Integer seedsPerCell) {
		this.seedsPerCell = seedsPerCell;
	}
}
