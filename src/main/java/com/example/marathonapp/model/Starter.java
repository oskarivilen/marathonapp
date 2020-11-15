package com.example.marathonapp.model;

import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonBackReference;

// Creation of starting time entity

@Entity
public class Starter {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long starterid;
	public String stime;
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "starter")
	private List<Runner> runners;
	
	public Starter() {}
	
	public Starter(String stime) {
		super();
		this.stime = stime;
	}
	
	public Long getStarterId() {
		return starterid;
	}
	
	public void setStarterId(Long starterid) {
		this.starterid = starterid;
	}
	
	public String getStime() {
		return stime;
	}
	
	public void setStime(String stime) {
		this.stime = stime;
	}

	public List<Runner> getRunners() {
		return runners;
	}

	public void setsRunners(List<Runner> runners) {
		this.runners = runners;
	}

	@Override
	public String toString() {
		return "Starter [starterid=" + starterid + ", stime=" + stime + "]";
	}
}
