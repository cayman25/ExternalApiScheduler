package pl.bookmaker.externalservice.demo.models.entity;



import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table
public class Team {
	
	@Id
	private int teamId;
	private String teamName;


	public Team() {
	}
	
	public Team(int teamId, String teamName) {
		this.teamId = teamId;
		this.teamName = teamName;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
		
}
