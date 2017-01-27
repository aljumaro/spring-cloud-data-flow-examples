package com.aljumaro.techtest.stream.db;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIME_INFO")
public class TimeInfo {

	@Id
	private String id;
	private Date tick;
	private String label;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getTick() {
		return tick;
	}

	public void setTick(Date tick) {
		this.tick = tick;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
