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



@Entity
public class Group {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long groupid;
	private String stime;
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
	private List<Runner> runners;
	
	public Group() {}
	
	public Group(String stime) {
		super();
		this.stime = stime;
	}
	
	public Long getGroupid() {
		return groupid;
	}
	
	public void setGroupId(Long groupid) {
		this.groupid = groupid;
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
		return "Group [groupid=" + groupid + ", stime=" + stime + "]";
	}
}
