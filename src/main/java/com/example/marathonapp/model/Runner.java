package com.example.marathonapp.model;

import javax.persistence.FetchType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Runner {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	
	private long id;
	private String name;
	private String team;
	
	

	
	 
	
	 public Runner() {}
	 
	 public Runner(long id,String name, String team) {
			super();
			this.id = id;
			this.name = name;
			this.team = team;
			
		
		}
	 public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
	
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	

	
	@Override
	public String toString() {
		
		return	"Runner [id=" + id + ", name=" + name + ", team=" + team +  "]";
	}

}