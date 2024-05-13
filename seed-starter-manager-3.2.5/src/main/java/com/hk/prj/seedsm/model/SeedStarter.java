package com.hk.prj.seedsm.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;


@Entity
public class SeedStarter extends BaseEntity{

	
	private LocalDateTime datePlanted;
	private Boolean covered;
	private String type;
	private String features;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Row> rows= new ArrayList<>();

	public LocalDateTime getDatePlanted() {
		return datePlanted;
	}

	public void setDatePlanted(LocalDateTime datePlanted) {
		this.datePlanted = datePlanted;
	}

	public Boolean getCovered() {
		return covered;
	}

	public void setCovered(Boolean covered) {
		this.covered = covered;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public List<Row> getRows() {
		return rows;
	}

	public void setRows(List<Row> rows) {
		this.rows = rows;
	}
}
